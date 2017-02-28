package come.comenie.guava.Collections.ext;

/**
 * Forwarding {@link com.google.common.collect.ForwardingList}装饰器
 *
 *
 * Forwarding抽象类定义了一个抽象方法：delegate()，你可以覆盖这个方法来返回被装饰对象。
 * 所有其他方法都会直接委托给delegate()。例如说：ForwardingList.get(int)实际上执行了delegate().get(int)。
 *
 * Created by 波 on 2017/1/20.
 */
public class ForwardingUtil {
}
