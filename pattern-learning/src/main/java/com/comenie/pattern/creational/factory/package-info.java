/**
 * Created by 波 on 2017/2/4.
 */
package com.comenie.pattern.creational.factory;
/**
 * 工厂方法模式(Factory Method Pattern): 定义一个用于创建对象的接口，让子类决定将哪一个
 * 类实例化。工厂方法模式让一个类的实例化延迟到其子类。工厂方法模式又简称为工厂模式
 * (Factory Pattern)，又可称作虚拟构造器模式(Virtual Constructor Pattern)或多态工厂模式
 * (Polymorphic Factory Pattern)。工厂方法模式是一种类创建型模式。
 *
 * Product（抽象产品）：它是定义产品的接口，是工厂方法模式所创建对象的超类型，也就是产品对象的公共父类。
 *
 * ConcreteProduct（具体产品）：它实现了抽象产品接口，某种类型的具体产品由专门的具体
 * 工厂创建，具体工厂和具体产品之间一一对应。
 *
 * Factory（抽象工厂）：在抽象工厂类中，声明了工厂方法(Factory Method)，用于返回一个
 * 产品。抽象工厂是工厂方法模式的核心，所有创建对象的工厂类都必须实现该接口。
 *
 * ConcreteFactory（具体工厂）：它是抽象工厂类的子类，实现了抽象工厂中定义的工厂方
 * 法，并可由客户端调用，返回一个具体产品类的实例。
 *
 */
