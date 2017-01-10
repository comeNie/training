package come.comenie.guava.Strings;

/**
 * 拆分器Splitter {@link com.google.common.base.Splitter}，可以替换String的split操作。
 * 拆分器工厂提供了按照char, CharMatcher,Pattern,String，Length拆分的方法。
 *
 * 在使用拆分器的过程中，可以指定拆分器的行为：
 *  omitEmptyStrings()     从结果中自动忽略空字符串
 *  trimResults()         移除结果字符串的前导空白和尾部空白
 *  trimResults(CharMatcher)     给定匹配器，移除结果字符串的前导匹配字符和尾部匹配字符
 *  limit(int)               限制拆分出的字符串数量
 *
 * 并提供 withKeyValueSeparator(), 字符串转换Map.  MapSplitter
 * Created by 波 on 2017/1/9.
 */
public class SplitterUtil {
}
