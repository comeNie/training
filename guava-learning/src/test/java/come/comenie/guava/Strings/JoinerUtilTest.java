package come.comenie.guava.Strings;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by 波 on 2017/1/9.
 */
public class JoinerUtilTest {

    @Test
    public void  testNormoalJoiner(){
        Assert.assertEquals("a,b,c", Joiner.on(",").join(new String[]{"a","b","c"}));
    }

    @Test
    public void testNullJoinerDefault(){
        Assert.assertEquals("a,b,null,c",Joiner.on(",").useForNull("null").join(new String[]{"a","b",null,"c"}));
    }

    @Test
    public void  testSkipNullJoiner(){
        Assert.assertEquals("a,b,c",Joiner.on(",").skipNulls().join(new String[]{"a","b",null,"c"}));
    }

    @Test
    public void testMapJoiner(){
        Map<String,String> maps = Maps.newHashMap();
        maps.put("1","a");
        maps.put("2","b");
        String  mapString =Joiner.on(",").withKeyValueSeparator("&").join(maps);
        Assert.assertEquals("1&a,2&b",mapString);
    }
}