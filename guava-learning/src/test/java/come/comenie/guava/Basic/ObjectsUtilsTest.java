package come.comenie.guava.Basic;

import com.google.common.base.Objects;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 波 on 2017/1/9.
 */
public class ObjectsUtilsTest {

    @Test
    public void testEquals() {
        Assert.assertFalse(Objects.equal(null,5));
        Assert.assertFalse(Objects.equal(5,null));
        Assert.assertTrue(Objects.equal(5,5));
        Assert.assertTrue(Objects.equal(null,null));

    }
    @Test
    public void  testHashCode(){
        Objects.hashCode(1,1,1,1);
    }

    public void testToString(){
    }
}