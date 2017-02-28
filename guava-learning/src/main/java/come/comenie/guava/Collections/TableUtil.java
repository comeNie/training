package come.comenie.guava.Collections;

/**
 * Table {@link com.google.common.collect.Table}，它有两个支持所有类型的键：”行”和”列”
 *
 * 当你想使用多个键做索引的时候，你可能会用类似Map<FirstName, Map<LastName, Person>>的实现
 *
 * rowMap()：用Map<R, Map<C, V>>表现Table<R, C, V>。同样的， rowKeySet()返回”行”的集合Set<R>。
 * row(r) ：用Map<C, V>返回给定”行”的所有列，对这个map进行的写操作也将写入Table中。
 * 类似的列访问方法：columnMap()、columnKeySet()、column(c)。（基于列的访问会比基于的行访问稍微低效点）
 * cellSet()：用元素类型为Table.Cell<R, C, V>的Set表现Table<R, C, V>。Cell类似于Map.Entry，但它是用行和列两个键区分的。
 *
 * Table有如下几种实现：
 * HashBasedTable：本质上用HashMap<R, HashMap<C, V>>实现；
 * TreeBasedTable：本质上用TreeMap<R, TreeMap<C,V>>实现；
 * ImmutableTable：本质上用ImmutableMap<R, ImmutableMap<C, V>>实现；注：ImmutableTable对稀疏或密集的数据集都有优化。
 * ArrayTable：要求在构造时就指定行和列的大小，本质上由一个二维数组实现，以提升访问速度和密集Table的内存利用率。ArrayTable与其他Table的工作原理有点不同，
 *  Created by 波 on 2017/1/20.
 */
public class TableUtil {
}
