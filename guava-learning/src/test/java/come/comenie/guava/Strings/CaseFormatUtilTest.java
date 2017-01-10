package come.comenie.guava.Strings;

import com.google.common.base.CaseFormat;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 波 on 2017/1/10.
 */
public class CaseFormatUtilTest {

    @Test
    public void testUpperUnderscoreToLowerCamel() {
        Assert.assertEquals("lowerCamel", CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,"LOWER_CAMEL"));
    }

    @Test
    public void testUpperUnderscoreToUpperCamel() {
        Assert.assertEquals("LowerCamel", CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL,"LOWER_CAMEL"));
    }

    @Test
    public void testUpperUnderscoreToLowerHyphen() {
        Assert.assertEquals("lower-camel", CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN,"LOWER_CAMEL"));
    }

}