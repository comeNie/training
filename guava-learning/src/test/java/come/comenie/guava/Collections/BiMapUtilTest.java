package come.comenie.guava.Collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 波 on 2017/1/20.
 */
public class BiMapUtilTest {
    private static  BiMap<String,String> biMap = HashBiMap.create();

    @After
    public void tearDown() {
        if(null != biMap){
            biMap.clear();
        }
    }

    @Test
    public void testForcePut() {
        biMap.put("v1","v2");
        biMap.forcePut("v3","v2");
        Assert.assertEquals("v3",biMap.keySet().iterator().next());
        Assert.assertEquals("v2",biMap.get("v3"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPut() {
        biMap.put("v1","v2");
        biMap.put("v3","v2");
    }

    @Test
    public void testInverse() {
        biMap.put("v1","v2");
        biMap.put("v2","v3");
        Assert.assertEquals(biMap, biMap.inverse().inverse());
    }

}