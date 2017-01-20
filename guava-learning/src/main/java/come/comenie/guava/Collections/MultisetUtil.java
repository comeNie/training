package come.comenie.guava.Collections;

/**
 * 新集合类型。 {@link com.google.common.collect.Multiset}
 *
 * 集合[set]概念的延伸，它的元素可以重复出现…与集合[set]相同而与元组[tuple]相反的是，Multiset元素的顺序是无关紧要的：Multiset {a, a, b}和{a, b, a}是相等的
 * 当把Multiset看成普通的Collection时，它表现得就像无序的ArrayList：

 * add(E)添加单个给定元素
 * iterator()返回一个迭代器，包含Multiset的所有元素（包括重复的元素）
 * size()返回所有元素的总个数（包括重复的元素）
 * 当把Multiset看作Map<E, Integer>时，它也提供了符合性能期望的查询操作：
 *
 * count(Object)返回给定元素的计数。HashMultiset.count的复杂度为O(1)，TreeMultiset.count的复杂度为O(log n)。
 * entrySet()返回Set<Multiset.Entry<E>>，和Map的entrySet类似。
 * elementSet()返回所有不重复元素的Set<E>，和Map的keySet()类似。
 * 所有Multiset实现的内存消耗随着不重复元素的个数线性增长。
 *
 * 方法：
 * 方法	                    描述
 * count(E)         	给定元素在Multiset中的计数
 * elementSet()	    Multiset中不重复元素的集合，类型为Set<E>
 * entrySet()	    和Map的entrySet类似，返回Set<Multiset.Entry<E>>，其中包含的Entry支持getElement()和getCount()方法
 * add(E, int)	    增加给定元素在Multiset中的计数
 * remove(E, int)	减少给定元素在Multiset中的计数
 * setCount(E, int)	设置给定元素在Multiset中的计数，不可以为负数
 * size()	        返回集合元素的总个数（包括重复的元素）
 *
 * 实现：
 *
 *   Map	            对应的Multiset	            是否支持null元素
 * HashMap	            HashMultiset	            是
 * TreeMap	            TreeMultiset	            是（如果comparator支持的话）
 * LinkedHashMap	    LinkedHashMultiset	        是
 * ConcurrentHashMap	ConcurrentHashMultiset	    否
 * ImmutableMap	        ImmutableMultiset	        否
 *
 * Created by 波 on 2017/1/20.
 */
public class MultisetUtil {
}
