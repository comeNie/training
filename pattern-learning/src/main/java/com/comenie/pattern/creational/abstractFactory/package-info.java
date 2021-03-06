/**
 * Created by 波 on 2017/2/4.
 */
package com.comenie.pattern.creational.abstractFactory;
/**
 * 抽象工厂模式(Abstract Factory Pattern)：提供一个创建一系列相关或相互依赖对象的接口，而
 * 无须指定它们具体的类。抽象工厂模式又称为Kit模式，它是一种对象创建型模式。
 *
 * AbstractFactory（抽象工厂）：它声明了一组用于创建一族产品的方法，每一个方法对应一种产品。
 *
 * ConcreteFactory（具体工厂）：它实现了在抽象工厂中声明的创建产品的方法，生成一组具
 * 体产品，这些产品构成了一个产品族，每一个产品都位于某个产品等级结构中。
 *
 * AbstractProduct（抽象产品）：它为每种产品声明接口，在抽象产品中声明了产品所具有的
 * 业务方法。
 *
 * ConcreteProduct（具体产品）：它定义具体工厂生产的具体产品对象，实现抽象产品接口中声明的业务方法
 *
 *
 */
