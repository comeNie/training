/**
 * Created by 波 on 2017/2/4.
 */
package com.comenie.pattern.creational.prototype;
/**
 *  原型模式(Prototype Pattern)：使用原型实例指定创建对象的种类，并且通过拷贝这些
 *  原型创建新的对象。原型模式是一种对象创建型模式。
 * Prototype（抽象原型类）：它是声明克隆方法的接口，是所有具体原型类的公共父类，可以
 * 是抽象类也可以是接口，甚至还可以是具体实现类。
 *
 *  ConcretePrototype（具体原型类）：它实现在抽象原型类中声明的克隆方法，在克隆方法中
 * 返回自己的一个克隆对象。
 *
 *  Client（客户类）：让一个原型对象克隆自身从而创建一个新的对象，在客户类中只需要直
 * 接实例化或通过工厂方法等方式创建一个原型对象，再通过调用该对象的克隆方法即可得到
 * 多个相同的对象
 *
 * 浅克隆(ShallowClone)和深克隆(DeepClone)
 *
 *  浅克隆(ShallowClone) 实现 cloneable 接口 ，通过覆盖Object类的clone()方法可以实现浅克隆
 *
 *  深克隆(DeepClone) 通过对象的序列化方式
 */
