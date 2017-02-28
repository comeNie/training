package come.comenie.guava.Collections.ext;

/**
 * AbstractIterator {@link com.google.common.base.AbstractIterator}
 * AbstractIterator继承了UnmodifiableIterator，所以禁止实现remove()方法。
 * 如果你需要支持remove()的迭代器，就不应该继承AbstractIterator
 *
 * AbstractSequentialIterator {@link com.google.common.collect.AbstractSequentialIterator}
 * 你必须额外传入一个初始值，或者传入null让迭代立即结束。
 * 因为computeNext(T)假定null值意味着迭代的末尾——AbstractSequentialIterator不能用来实现可能返回null的迭代器。
 * Created by 波 on 2017/1/20.
 */
public class IteratorUtil {
}
