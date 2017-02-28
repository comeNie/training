package come.comenie.guava.Basic;

/**
 * Throwables 异常处理 {@link com.google.common.base.Throwables}
 *  RuntimeException   propagate(Throwable)	如果Throwable是Error或RuntimeException，直接抛出；
 *  否则把Throwable包装成RuntimeException抛出。返回类型是RuntimeException，
 *  所以你可以像上面说的那样写成throw Throwables.propagate(t)，Java编译器会意识到这行代码保证抛出异常。
 * void propagateIfInstanceOf( Throwable, Class<X extends   Exception>) throws X
 *  Throwable类型为X才抛出
 * void propagateIfPossible( Throwable)	Throwable类型为Error或RuntimeException才抛出
 * void propagateIfPossible( Throwable, Class<X extends Throwable>) throws X
 * Throwable类型为X, Error或RuntimeException才抛出
 *
 * Throwable   getRootCause(Throwable)
 * List<Throwable>   getCausalChain(Throwable)
 * String   getStackTraceAsString(Throwable)
 *
 * todo 编写单元测试用例
 * Created by 波 on 2017/1/9.
 */
public class ThrowablesUtil {
}
