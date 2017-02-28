package come.comenie.guava.Ranges;

/**
 * 区间 {@link com.google.common.collect.Range}。
 * 区间的实例可以根据静态方法获取：
 *
 * (a..b)	    open(C, C)
 * [a..b]	    closed(C, C)
 * [a..b)	    closedOpen(C, C)
 * (a..b]	    openClosed(C, C)
 * (a..+∞)	    greaterThan(C)
 * [a..+∞)	    atLeast(C)
 * (-∞..b)	    lessThan(C)
 * (-∞..b]	    atMost(C)
 * (-∞..+∞)	    all()
 *
 * 此外可以通过明确的指定边界类型{@link com.google.common.collect.BoundType}构造区间：
 * 有界区间	range(C, BoundType, C,   BoundType)
 * 无上界区间：((a..+∞) 或[a..+∞))	downTo(C, BoundType)
 * 无下界区间：((-∞..b) 或(-∞..b])	upTo(C, BoundType)
 *
 * 区间运算：
 *  contains(C)   包含
 *  containsAll() 包含所有
 *
 * 查询运算：
 * hasLowerBound()和hasUpperBound()：判断区间是否有特定边界，或是无限的；
 * lowerBoundType()和upperBoundType()：返回区间边界类型，CLOSED或OPEN；如果区间没有对应的边界，抛出IllegalStateException；
 * lowerEndpoint()和upperEndpoint()：返回区间的端点值；如果区间没有对应的边界，抛出IllegalStateException；
 * isEmpty()：判断是否为空区间。
 *
 * 关系运算：
 * [encloses(Range)]  包含
 * [isConnected]  相连
 * [intersection] 交集
 * [span]  跨区间
 *
 *  实际上Range规定元素类型必须是Comparable，这已经满足了大多数需求。如果需要自定义特殊的比较逻辑，可以用Predicates.compose(range, function)组合比较的function。
 *
 * // todo Cut{@link com.google.common.collect.Cut} and  DiscreteDomain {@link com.google.common.collect.DiscreteDomain}
 *
 * Created by 波 on 2017/1/11.
 */
public class RangeUtil {
}
