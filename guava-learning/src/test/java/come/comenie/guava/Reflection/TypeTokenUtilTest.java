package come.comenie.guava.Reflection;

import com.google.common.reflect.TypeToken;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 波 on 2017/1/19.
 */
public class TypeTokenUtilTest {
    private abstract static class StringList implements List<String> {}

    private abstract static class IntegerList implements List<Integer> {}

    @Test
    public void testEquals() {
        TypeToken<List<String>> a = new TypeToken<List<String>>() {
        };
        TypeToken<List<String>> b = new TypeToken<List<String>>() {
        };
        assertEquals(a,b);
    }

    @Test
    public void testRawType() {
        TypeToken<List<String>> a = new TypeToken<List<String>>() {};
        assertEquals(List.class,a.getRawType());
    }

    @Test
    public void testClass() {
        TypeToken<List<String>> token = new TypeToken<List<String>>() {};
        assertEquals(StringList.class.getGenericInterfaces()[0], token.getType());
    }


}