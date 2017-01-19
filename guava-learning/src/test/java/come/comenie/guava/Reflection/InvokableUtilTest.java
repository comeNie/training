package come.comenie.guava.Reflection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeToken;

import org.junit.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 波 on 2017/1/19.
 */
public class InvokableUtilTest {

    @Test
    public void testReturnTypeAndOwnerType() throws NoSuchMethodException {
           Method getMethod = List.class.getMethod("get", int.class);
           Invokable<List<String>, ?> invokable = new TypeToken<List<String>>() {}.method(getMethod);
           assertEquals(TypeToken.of(String.class), invokable.getReturnType()); // Not Object.class!
           assertEquals(new TypeToken<List<String>>() {}, invokable.getOwnerType());
    }

    @Test
    public void testConstructor_returnType() throws Exception {
        assertEquals(Prepender.class, Prepender.constructor().getReturnType().getType());
    }

    @Test
    public void testConstructor_call() throws Exception {
        Invokable<?, Prepender> delegate = Prepender.constructor(String.class, int.class);
        Prepender prepender = delegate.invoke(null, "a", 1);
        assertEquals("a", prepender.prefix);
        assertEquals(1, prepender.times);
    }

    @Test
    public void testStaticMethod_call() throws Exception {
        Invokable<?, ?> delegate = Prepender.method("prepend", String.class, Iterable.class);
        @SuppressWarnings("unchecked") // prepend() returns Iterable<String>
                Iterable<String> result = (Iterable<String>)
                delegate.invoke(null, "a", ImmutableList.of("b", "c"));
        assertEquals(ImmutableList.of("a", "b", "c"), ImmutableList.copyOf(result));
    }

    @Test
    public void testInstanceMethod_call() throws Exception {
        Invokable<Prepender, ?> delegate = Prepender.method("prepend", Iterable.class);
        @SuppressWarnings("unchecked") // prepend() returns Iterable<String>
                Iterable<String> result = (Iterable<String>)
                delegate.invoke(new Prepender("a", 2), ImmutableList.of("b", "c"));
        assertEquals(ImmutableList.of("a", "a", "b", "c"), ImmutableList.copyOf(result));
    }

    @Test
    public void testStaticMethod_isOverridable() throws Exception {
        Invokable<?, ?> delegate = Prepender.method("staticMethod");
        assertTrue(delegate.isStatic());
        assertFalse(delegate.isOverridable());
        assertFalse(delegate.isVarArgs());
    }


    @Retention(RetentionPolicy.RUNTIME)
    private @interface NotBlank {}

    //test for reflection
    private static class Prepender {

        private final String prefix;
        private final int times;

        Prepender(@NotBlank String prefix, int times) throws NullPointerException {
            this.prefix = prefix;
            this.times = times;
        }

        Prepender(String... varargs) {
            this(null, 0);
        }

        // just for testing
        private <A> Prepender() {
            this(null, 0);
        }

        static <T> Iterable<String> prepend(@NotBlank String first, Iterable<String> tail) {
            return Iterables.concat(ImmutableList.of(first), tail);
        }

        Iterable<String> prepend(Iterable<String> tail)
                throws IllegalArgumentException, NullPointerException {
            return Iterables.concat(Collections.nCopies(times, prefix), tail);
        }

        static Invokable<?, Prepender> constructor(Class<?>... parameterTypes) throws Exception {
            Constructor<Prepender> constructor = Prepender.class.getDeclaredConstructor(parameterTypes);
            return Invokable.from(constructor);
        }

        static Invokable<Prepender, Object> method(String name, Class<?>... parameterTypes) {
            try {
                Method method = Prepender.class.getDeclaredMethod(name, parameterTypes);
                @SuppressWarnings("unchecked") // The method is from Prepender.
                        Invokable<Prepender, Object> invokable = (Invokable<Prepender, Object>)
                        Invokable.from(method);
                return invokable;
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException(e);
            }
        }


        private void privateMethod() {}

        private final void privateFinalMethod() {}

        static void staticMethod() {}

        static final void staticFinalMethod() {}

        private void privateVarArgsMethod(String... varargs) {}
    }

    private static class SubPrepender extends Prepender {
        @SuppressWarnings("unused") // needed to satisfy compiler, never called
        public SubPrepender() throws NullPointerException {
            throw new AssertionError();
        }
    }
}