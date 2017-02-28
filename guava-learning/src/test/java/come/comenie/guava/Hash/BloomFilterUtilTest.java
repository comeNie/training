package come.comenie.guava.Hash;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * Created by 波 on 2017/1/18.
 */
public class BloomFilterUtilTest {

    // email规则
    private static final String  EMAIL = "^[a-zA-Z0-9]+([_.]?[a-zA-Z0-9])*@([a-zA-Z0-9]+\\.)+[a-zA-Z0-9]{2,3}$";
    /** 模拟数据容器 */
    private Set<String> mail_list  = Sets.newHashSet();
    /** 不匹配的数据 */
    private Set<String> no_mail_list = Sets.newHashSet();
    /** 布隆过滤器 */
    private BloomFilter<String> bloomFilter;

    @Before
    public void setUp() throws Exception {
        for (int i = 1; i <= 10000; i++) {
            if (i % 2 == 0) {
                no_mail_list.add("iflytek" + i);
            } else {
                mail_list.add("iflytek" + i + "@iflytek.com");
            }
        }

    }

    @Test
    public void test_BlootFilter() throws Exception {
        //创建过滤器
        int size = mail_list.size();
        //注意第二个参数
        bloomFilter = BloomFilter.create(stringFunnel(), size);

        addStoredStringToBloomFilter();

        int falsePositiveCount = 0;
        for (String s : no_mail_list) {
            boolean mightContain = bloomFilter.mightContain(s);
            if (!mightContain) {
                System.out.println("no equal bloomFilter:" + s);
                falsePositiveCount++;
            }
        }

        Assert.assertEquals(falsePositiveCount,no_mail_list.size());
    }

    public static Funnel<String> stringFunnel() {
        return StringFunnel.INSTANCE;
    }
    /** 将数据增加到布隆过滤器中 */
    private void addStoredStringToBloomFilter() {
        for (String email : mail_list) {
            bloomFilter.put(email);
        }
    }

    /** 自定义Funnel */
    private enum StringFunnel implements Funnel<String> {

        INSTANCE;
        @Override
        public void funnel(String from, PrimitiveSink into) {
            //如果不是邮箱地址，则不进入Slink接收器
            if (isEmail(from)) {
                into.putString(from, Charsets.UTF_8);
            }
        }

        /**
         * 验证字符串是否为合法的Email （Email格式是指：字母、数字、下划线与'@'和'.'的组合，'@'数量不得超过1；连续两位字符不能为'_'
         * 或'@'与'.'；不得以'@'或'.'或'_'开头；倒数第三位或第四位必须为'.'）
         *
         * @param email 要验证的字符串
         * @return 验证通过返回 true，否则返回 false
         */
        public boolean isEmail(String email) {
            return !Strings.isNullOrEmpty(email) && email.matches(EMAIL);
        }

    }

}