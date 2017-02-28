package come.comenie.guava.Collections;

/**
 * Guava的 Multimap {@link com.google.common.collect.Multimap}可以很容易地把一个键映射到多个值。换句话说，Multimap是把键映射到任意多个值的一般方式。
 *
 * 方法：
 *  put(K, V)	            添加键到单个值的映射	multimap.get(key).add(value)
 *  putAll(K, Iterable<V>)	依次添加键到多个值的映射	Iterables.addAll(multimap.get(key), values)
 *  remove(K, V)	        移除键到值的映射；如果有这样的键值并成功移除，返回true。	multimap.get(key).remove(value)
 *  removeAll(K)	        清除键对应的所有值，返回的集合包含所有之前映射到K的值，但修改这个集合就不会影响Multimap了。multimap.get(key).clear()
 *  replaceValues(K, Iterable<V>)	清除键对应的所有值，并重新把key关联到Iterable中的每个元素。
 *                                  返回的集合包含所有之前映射到K的值。	multimap.get(key).clear(); Iterables.addAll(multimap.get(key), values)
 *
 * 实现方式：
 *      实现	                键行为类似	        值行为类似
 * ArrayListMultimap	    HashMap	            ArrayList
 * HashMultimap	            HashMap	            HashSet
 * LinkedListMultimap*	    LinkedHashMap*	    LinkedList*
 * LinkedHashMultimap**	    LinkedHashMap	    LinkedHashMap
 * TreeMultimap	            TreeMap	            TreeSet
 * ImmutableListMultimap	ImmutableMap	    ImmutableList
 * ImmutableSetMultimap	    ImmutableMap	    ImmutableSet
 *  除了两个不可变形式的实现，其他所有实现都支持null键和null值
 *
 *
 * Created by 波 on 2017/1/20.
 */
public class MultimapUtil {
}
