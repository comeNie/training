/**
 * Created by 波 on 2017/2/7.
 */
package com.comenie.pattern.behavioral.iterator;
/**
 * 迭代器模式(Iterator Pattern)：提供一种方法来访问聚合对象，而不用暴露这个对象的内部表
 * 示，其别名为游标(Cursor)。
 *
 *  Iterator（抽象迭代器）：它定义了访问和遍历元素的接口，声明了用于遍历数据元素的方法
 *
 *  ConcreteIterator（具体迭代器）：它实现了抽象迭代器接口，完成对聚合对象的遍历，同时
 * 在具体迭代器中通过游标来记录在聚合对象中所处的当前位置，在具体实现时，游标通常是
 * 一个表示位置的非负整数
 *
 * Aggregate（抽象聚合类）：它用于存储和管理元素对象，声明一个createIterator()方法用于
 * 创建一个迭代器对象，充当抽象迭代器工厂角色。
 *
 * ConcreteAggregate（具体聚合类）：它实现了在抽象聚合类中声明的createIterator()方法，该
 * 方法返回一个与该具体聚合类对应的具体迭代器ConcreteIterator实例。
 */
