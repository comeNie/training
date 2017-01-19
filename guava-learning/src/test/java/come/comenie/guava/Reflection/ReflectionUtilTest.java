package come.comenie.guava.Reflection;

import com.google.common.reflect.Reflection;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by 波 on 2017/1/19.
 */
public class ReflectionUtilTest {

    @Test
    public void testGetPackageName() throws Exception {
        assertEquals("java.lang", Reflection.getPackageName(Iterable.class));
        assertEquals("java", Reflection.getPackageName("java.MyType"));
        assertEquals("java.lang", Reflection.getPackageName(Iterable.class.getName()));
        assertEquals("", Reflection.getPackageName("NoPackage"));
        assertEquals("java.util", Reflection.getPackageName(Map.Entry.class));
    }

    @Test
    public void testNewProxy() throws Exception {
        Runnable runnable = Reflection.newProxy(Runnable.class, X_RETURNER);
        assertEquals("x", runnable.toString());
    }

    @Test
    public void testNewProxyCantWorkOnAClass() throws Exception {
        try {
            Reflection.newProxy(Object.class, X_RETURNER);
            fail();
        } catch (IllegalArgumentException expected) {
        }
    }

    private static final InvocationHandler X_RETURNER = new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            return "x";
        }
    };


    private static int classesInitialized = 0;
    private static class A {
        static {
            ++classesInitialized;
        }
    }
    private static class B {
        static {
            ++classesInitialized;
        }
    }
    private static class C {
        static {
            ++classesInitialized;
        }
    }

}