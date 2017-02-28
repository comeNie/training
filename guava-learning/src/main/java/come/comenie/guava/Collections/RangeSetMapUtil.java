package come.comenie.guava.Collections;

/**
 *
 * RangeSet{@link com.google.common.collect.RangeSet}描述了一组不相连的、非空的区间。当把一个区间添加到可变的RangeSet时，所有相连的区间会被合并，空区间会被忽略
 * RangeSet的视图

 * RangeSet的实现支持非常广泛的视图：
 *
 * complement()：返回RangeSet的补集视图。complement也是RangeSet类型,包含了不相连的、非空的区间。
 * subRangeSet(Range<C>)：返回RangeSet与给定Range的交集视图。这扩展了传统排序集合中的headSet、subSet和tailSet操作。
 * asRanges()：用Set<Range<C>>表现RangeSet，这样可以遍历其中的Range。
 * asSet(DiscreteDomain<C>)（仅ImmutableRangeSet支持）：用ImmutableSortedSet<C>表现RangeSet，以区间中所有元素的形式而不是区间本身的形式查看。（这个操作不支持DiscreteDomain 和RangeSet都没有上边界，或都没有下边界的情况）
 * RangeSet的查询方法
 *
 * 为了方便操作，RangeSet直接提供了若干查询方法，其中最突出的有:
 *
 * contains(C)：RangeSet最基本的操作，判断RangeSet中是否有任何区间包含给定元素。
 * rangeContaining(C)：返回包含给定元素的区间；若没有这样的区间，则返回null。
 * encloses(Range<C>)：简单明了，判断RangeSet中是否有任何区间包括给定区间。
 * span()：返回包括RangeSet中所有区间的最小区间。
 *
 * RangeMap{@link com.google.common.collect.RangeMap}
 *
 * RangeMap描述了”不相交的、非空的区间”到特定值的映射
 *
 * RangeMap提供两个视图：
 * asMapOfRanges()：用Map<Range<K>, V>表现RangeMap。这可以用来遍历RangeMap。
 * subRangeMap(Range<K>)：用RangeMap类型返回RangeMap与给定Range的交集视图。这扩展了传统的headMap、subMap和tailMap操作。
 *
 * Created by 波 on 2017/1/20.
 */
public class RangeSetMapUtil {
}
