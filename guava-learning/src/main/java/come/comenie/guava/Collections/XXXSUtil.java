package come.comenie.guava.Collections;

/**
 * 包含了强大的集合工具类。
 * 集合接口	        属于JDK还是Guava	                对应的Guava工具类
 * Collection           JDK	            Collections2：不要和java.util.Collections混淆
 * List         	    JDK	            Lists
 * Set          	    JDK	            Sets
 * SortedSet            JDK	            Sets
 * Map          	    JDK	            Maps
 * SortedMap            JDK	            Maps
 * Queue            	JDK	            Queues
 * Multiset         	Guava	        Multisets
 * Multimap         	Guava	        Multimaps
 * BiMap            	Guava	        Maps
 * Table            	Guava	        Tables
 *
 * 同时包含Iteraotrs
 * Iterators 方法
 *  concat(Iterable<Iterable>)	        串联多个iterables的懒视图*	                                     concat(Iterable...)
 *  frequency(Iterable, Object)     	返回对象在iterable中出现的次数	                                     与Collections.frequency (Collection,   Object)比较；Multiset
 *  partition(Iterable, int)	        把iterable按指定大小分割，得到的子集都不能进行修改操作	            Lists.partition(List, int)；paddedPartition(Iterable, int)
 *  getFirst(Iterable, T default)	    返回iterable的第一个元素，若iterable为空则返回默认值	                与Iterable.iterator(). next()比较;FluentIterable.first()
 *  getLast(Iterable)	                返回iterable的最后一个元素，若iterable为空则抛出NoSuchElementException	getLast(Iterable, T default)；
 *  FluentIterable.last()
 *  elementsEqual(Iterable, Iterable)	如果两个iterable中的所有元素相等且顺序一致，返回true	                与List.equals(Object)比较
 *  unmodifiableIterable(Iterable)	    返回iterable的不可变视图	                                        与Collections. unmodifiableCollection(Collection)比较
 *  limit(Iterable, int)	            限制iterable的元素个数限制给定值	                                FluentIterable.limit(int)
 *  getOnlyElement(Iterable)            	获取iterable中唯一的元素，如果iterable为空或有多个元素，则快速失败	    getOnlyElement(Iterable, T default)
 *
 * FluentIterable{@link com.google.common.collect.FluentIterable}
 *
 * ImmutableSet	        toImmutableSet()
 * ImmutableSortedSet	toImmutableSortedSet(Comparator)
 *
 * Lists
 * 方法	                        描述
 * partition(List, int) 	把List按指定大小分割
 * reverse(List)	        返回给定List的反转视图。注: 如果List是不可变的，考虑改用ImmutableList.reverse()。
 *
 * Sets
 * union(Set, Set)
 * intersection(Set, Set)
 * difference(Set, Set)
 * symmetricDifference(Set,   Set)
 *
 *  方法	描述	另请参见
 * cartesianProduct(List<Set>)	返回所有集合的笛卡儿积	cartesianProduct(Set...)
 * powerSet(Set)	返回给定集合的所有子集
 *
 *  Maps
 *  Maps.uniqueIndex(Iterable,Function)通常针对的场景是：有一组对象，它们在某个属性上分别有独一无二的值，
 *  而我们希望能够按照这个属性值查找对象——译者注：这个方法返回一个Map，
 *  键为Function返回的属性值，值为Iterable中相应的元素，因此我们可以反复用这个Map进行查找操作。
 *
 *  Maps.difference(Map, Map) 用来比较两个Map以获取所有不同点
 *  entriesInCommon()	两个Map中都有的映射项，包括匹配的键与值
 *  entriesDiffering()	键相同但是值不同值映射项。返回的Map的值类型为MapDifference.ValueDifference，以表示左右两个不同的值
 *  entriesOnlyOnLeft()	键只存在于左边Map的映射项
 *  entriesOnlyOnRight()	键只存在于右边Map的映射项
 *
 * Multisets
 *
 * Created by 波 on 2017/1/20.
 */
public class XXXSUtil {
}
