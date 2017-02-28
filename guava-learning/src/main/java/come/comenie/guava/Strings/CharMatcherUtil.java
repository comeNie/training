package come.comenie.guava.Strings;

/**
 * CharMatcher {@link com.google.common.base.CharMatcher}实例代表着某一类字符，如数字或空白字符
 * 提供了一系列方法：
 * 修剪[trim]、折叠[collapse]、移除[remove]、保留[retain]
 * <code>
 *    String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom(string); //移除control字符
 *    String theDigits = CharMatcher.DIGIT.retainFrom(string); //只保留数字字符
 *    String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom(string, ' ');//去除两端的空格，并把中间的连续空格替换成单个空格
 *    String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom(string, "*"); //用*号替换所有数字
 *    String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(string);// 只保留数字和小写字母
 * </code>
 *
 * CharMatcher 实例：
 *  ANY: 匹配任何字符
 *  ASCII: 匹配是否是ASCII字符
 *  BREAKING_WHITESPACE: 匹配所有可换行的空白字符(不包括非换行空白字符,例如"\u00a0")
 *  DIGIT: 匹配ASCII数字
 *  INVISIBLE: 匹配所有看不见的字符
 *  JAVA_DIGIT: 匹配UNICODE数字, 使用 Character.isDigit() 实现
 *  JAVA_ISO_CONTROL: 匹配ISO控制字符, 使用 Charater.isISOControl() 实现
 *  JAVA_LETTER: 匹配字母, 使用 Charater.isLetter() 实现
 *  JAVA_LETTER_OR_DIGET: 匹配数字或字母
 *  JAVA_LOWER_CASE: 匹配小写
 *  JAVA_UPPER_CASE: 匹配大写
 *  NONE: 不匹配所有字符
 *  SINGLE_WIDTH: 匹配单字宽字符, 如中文字就是双字宽
 *  WHITESPACE: 匹配所有空白字符
 *
 *
 *  常用方法：
 *  CharMatcher is(char match): 返回匹配指定字符的Matcher
 *  CharMatcher isNot(char match): 返回不匹配指定字符的Matcher
 *  CharMatcher anyOf(CharSequence sequence): 返回匹配sequence中任意字符的Matcher
 *  CharMatcher noneOf(CharSequence sequence): 返回不匹配sequence中任何一个字符的Matcher
 *  CharMatcher inRange(char startInclusive, char endIncludesive): 返回匹配范围内任意字符的Matcher
 *  CharMatcher forPredicate(Predicate<? super Charater> predicate): 返回使用predicate的apply()判断匹配的Matcher
 *  CharMatcher negate(): 返回以当前Matcher判断规则相反的Matcher
 *  CharMatcher and(CharMatcher other): 返回与other匹配条件组合做与来判断的Matcher
 *  CharMatcher or(CharMatcher other): 返回与other匹配条件组合做或来判断的Matcher
 *  boolean matchesAnyOf(CharSequence sequence): 只要sequence中有任意字符能匹配Matcher,返回true
 *  boolean matchesAllOf(CharSequence sequence): sequence中所有字符都能匹配Matcher,返回true
 *  boolean matchesNoneOf(CharSequence sequence): sequence中所有字符都不能匹配Matcher,返回true
 *  int indexIn(CharSequence sequence): 返回sequence中匹配到的第一个字符的坐标
 *  int indexIn(CharSequence sequence, int start): 返回从start开始,在sequence中匹配到的第一个字符的坐标
 *  int lastIndexIn(CharSequence sequence): 返回sequence中最后一次匹配到的字符的坐标
 *  int countIn(CharSequence sequence): 返回sequence中匹配到的字符计数
 *  String removeFrom(CharSequence sequence): 删除sequence中匹配到到的字符并返回
 *  String retainFrom(CharSequence sequence): 保留sequence中匹配到的字符并返回
 *  String replaceFrom(CharSequence sequence, char replacement): 替换sequence中匹配到的字符并返回
 *  String trimFrom(CharSequence sequence): 删除首尾匹配到的字符并返回
 *  String trimLeadingFrom(CharSequence sequence): 删除首部匹配到的字符
 *  String trimTrailingFrom(CharSequence sequence): 删除尾部匹配到的字符
 *  String collapseFrom(CharSequence sequence, char replacement): 将匹配到的组(连续匹配的字符)替换成replacement
 *  String trimAndCollapseFrom(CharSequence sequence, char replacement): 先trim在replace
 *
 *  Created by 波 on 2017/1/10.
 *  todo 编写CharMatcher测试用例
 */
public class CharMatcherUtil {
}
