package come.comenie.guava.Collections;

/**
 * Guava 提供了一系列的不可变集合类.
 * 与之相比较的是 Collections 方法中的: unmodifiableXXX方法
 * 创建不可变集合类的方法:
 * of(); 如ImmutableSet.copyOf(set);
 * copyOf();  ImmutableMap.of(“a”, 1, “b”, 2);
 *
 * 可变集合接口	    属于JDK还是Guava	   不可变版本
 * Collection	            JDK	    ImmutableCollection
 * List	                    JDK	    ImmutableList
 * Set	                    JDK	    ImmutableSet
 * SortedSet/NavigableSet	JDK	    ImmutableSortedSet
 * Map	                    JDK	    ImmutableMap
 * SortedMap	            JDK	    ImmutableSortedMap
 * Multiset             	Guava	ImmutableMultiset
 * SortedMultiset	        Guava	ImmutableSortedMultiset
 * Multimap	                Guava	ImmutableMultimap
 * ListMultimap         	Guava	ImmutableListMultimap
 * SetMultimap	            Guava	ImmutableSetMultimap
 * BiMap	                Guava	ImmutableBiMap
 * ClassToInstanceMap	    Guava	ImmutableClassToInstanceMap
 * Table	                Guava	ImmutableTable
 *
 * Created by comeNie on 17/1/10.
 */
public class ImmutableUtil {
}
