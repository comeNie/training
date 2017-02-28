package come.comenie.guava.Collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by 波 on 2017/1/20.
 */
public class ImmutableUtilTest {

    private static List<Integer> LIST = Lists.newArrayList(1,2,3);
    private static Set<Integer> SET = Sets.newHashSet(LIST);


    @Test
    public void testCopyOf() {
        ImmutableList<Integer> immutableList = ImmutableList.copyOf(LIST);
        Assert.assertEquals(immutableList.toArray(),LIST.toArray());
    }

    @Test
    public void testOf() {
        ImmutableSet<Integer> immutableSet = ImmutableSet.of(1,2,3);
        Assert.assertEquals(immutableSet.toArray(),SET.toArray());
    }

    @Test
    public void testBuilder() {
        ImmutableSet<Integer> immutableSet = ImmutableSet.<Integer>builder().add(1).add(2).add(3).build();
        Assert.assertEquals(immutableSet.toArray(),SET.toArray());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testModify() {
        ImmutableList<Integer> immutableList = ImmutableList.copyOf(LIST);
        immutableList.add(4);
    }

}