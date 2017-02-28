package come.comenie.guava.Basic;

/**
 * 排序器 {@link com.google.common.collect.Ordering}, 可以构造复杂的排序器.
 * natural()	对可排序类型做自然排序，如数字按大小，日期按先后排序
 * usingToString()	按对象的字符串形式做字典排序[lexicographical ordering]
 * from(Comparator)	把给定的Comparator转化为排序器
 *
 * 链式调用方法：通过链式调用，可以由给定的排序器衍生出其它排序器
 * reverse()	获取语义相反的排序器
 * nullsFirst()	使用当前排序器，但额外把null值排到最前面。
 * nullsLast()	使用当前排序器，但额外把null值排到最后面。
 * compound(Comparator)	合成另一个比较器，以处理当前排序器中的相等情况。
 * lexicographical()	基于处理类型T的排序器，返回该类型的可迭代对象Iterable<T>的排序器。
 * onResultOf(Function)	对集合中元素调用Function，再按返回值用当前排序器排序。
 *
 * todo ordering 单元测试用例编写
 *
 * Created by 波 on 2017/1/9.
 */
public class OrderingUtil {
}
