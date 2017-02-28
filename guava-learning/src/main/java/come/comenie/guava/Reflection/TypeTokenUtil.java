package come.comenie.guava.Reflection;

/**
 * TypeToken {@link com.google.common.reflect.TypeToken}
 *
 * Java不能在运行时保留对象的泛型类型信息,TypeToken 能在运行时操作和查询泛型类型。
 *
 *      方法	                                描述
 *  getType()	                获得包装的java.lang.reflect.Type.
 *  getRawType()	            返回大家熟知的运行时类
 *  getSubtype(Class<?>)	    返回那些有特定原始类的子类型。举个例子，如果这有一个Iterable并且参数是List.class，那么返回将是List。
 *  getSupertype(Class<?>)	    产生这个类型的超类，这个超类是指定的原始类型。举个例子，如果这是一个Set并且参数是Iterable.class，结果将会是Iterable。
 *  isAssignableFrom(type)	    如果这个类型是 assignable from 指定的类型，并且考虑泛型参数，返回true。List<? extends Number>是assignable from List，但List没有.
 *  getTypes()	                返回一个Set，包含了这个所有接口，子类和类是这个类型的类。返回的Set同样提供了classes()和interfaces()方法允许你只浏览超类和接口类。
 *  isArray()	                检查某个类型是不是数组，甚至是<? extends A[]>。
 *  getComponentType()	        返回组件类型数组。
 *
 *
 *  TypeToken将Java提供的TypeVariables和context token中的类型变量统一起来。这可以被用来一般性地推断出在一个类型相关方法的返回类型：
 *  <code>
 *      TypeToken<Map<String, Integer>> mapToken = new TypeToken<Map<String, Integer>>() {};
 *      TypeToken<?> entrySetToken = mapToken.resolveType(Map.class.getMethod("entrySet").getGenericReturnType());
 *  </code>
 *
 *
 * Created by 波 on 2017/1/19.
 */
public class TypeTokenUtil {



}
