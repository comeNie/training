package come.comenie.guava.Collections;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 波 on 2017/1/20.
 */
public class MultimapUtilTest {

    @Test
    public void testPut() {
        Multimap<String,Integer> multimap = HashMultimap.create();
        multimap.put("a",1);
        multimap.put("a",2);
        Assert.assertEquals(Sets.newHashSet(1,2),multimap.get("a"));
    }

    @Test
    public void testKeys() {
        Multimap<String,Integer> multimap = HashMultimap.create();
        multimap.put("a",1);
        multimap.put("a",2);

        Multiset<String> keys = multimap.keys();
        Assert.assertEquals(2,keys.count("a"));
    }

}