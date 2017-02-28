package come.comenie.guava.Basic;

/**
 * 避免使用null {@link com.google.common.base.Optional}.
 * Optional.of(T)  创建指定引用的Optional实例，若引用为null则快速失败
 * Optional.absent()	创建引用缺失的Optional实例
 * Optional.fromNullable(T)	创建指定引用的Optional实例，若引用为null则表示缺失
 * boolean isPresent()	如果Optional包含非null的引用（引用存在），返回true
 * T get()	返回Optional所包含的引用，若引用缺失，则抛出java.lang.IllegalStateException
 * T or(T)	返回Optional所包含的引用，若引用缺失，返回指定的值
 * T orNull()	返回Optional所包含的引用，若引用缺失，返回null
 * Set<T> asSet()	返回Optional所包含引用的单例不可变集，如果引用存在，返回一个只有单一元素的集合，如果引用缺失，返回一个空集合。
 * Created by 波 on 2017/1/6.
 */
public class OptionalUtil {
}
