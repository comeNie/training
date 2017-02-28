package come.comenie.guava.Basic;

/**
 *  提供常用的equals, toString,hashcode方法.{@link com.google.common.base.Objects}
 *  Objects.equal帮助你执行null敏感的equals判断，从而避免抛出NullPointerException
 *
 *  用对象的所有字段作散列[hash]运算应当更简单。Guava的Objects.hashCode(Object...)
 *  会对传入的字段序列计算出合理的、顺序敏感的散列值。
 *  可以使用Objects.hashCode(field1, field2, …, fieldn)来代替手动计算散列值。
 *
 *  使用 Objects.toStringHelper可以轻松编写有用的toString方法
 *
 *  compare/compareTo  通过流式风格的ComparisonChain编写
 *
 *  Created by 波 on 2017/1/9.
 */
public class ObjectsUtils {
}
