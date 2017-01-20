package come.comenie.guava.Collections;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 波 on 2017/1/20.
 */
public class MultisetUtilTest {
    @Test
    public void testEquals() {
        Multiset<String> multiset = HashMultiset.create(Lists.newArrayList("a","b","a","c"));
        Assert.assertEquals(multiset,HashMultiset.create(Lists.newArrayList("a","b","c","a")));
    }

    @Test
    public void testCount() {
        Multiset<String> multiset = HashMultiset.create(Lists.newArrayList("a","b","a","c"));
        Assert.assertEquals(2,multiset.count("a"));
    }


}