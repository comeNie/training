package come.comenie.guava.Primitives;

/**
 * guava 封装的原生工具类
 *
 * 原生类型	Guava工具类（都在com.google.common.primitives包）
 * byte     	Bytes, SignedBytes, UnsignedBytes
 * short        Shorts
 * int      	Ints, UnsignedInteger, UnsignedInts
 * long     	Longs, UnsignedLong, UnsignedLongs
 * float        Floats
 * double       Doubles
 * char     	Chars
 * boolean      Booleans
 *
 * 原生类型数组工具
 * 原生类型数组是处理原生类型集合的最有效方式（从内存和性能双方面考虑）
 * 方法签名	                                                    描述	                                          类似方法	           可用性
 * List<Wrapper> asList(prim… backingArray)	        把数组转为相应包装类的List	                            Arrays.asList	        符号无关*
 * prim[] toArray(Collection<Wrapper> collection)	把集合拷贝为数组，和collection.toArray()一样线程安全	Collection.toArray()	符号无关
 * prim[] concat(prim[]… arrays)	                串联多个原生类型数组	                                Iterables.concat	    符号无关
 * boolean contains(prim[] array, prim target)	    判断原生类型数组是否包含给定值	                        Collection.contains	    符号无关
 * int indexOf(prim[] array, prim target)	        给定值在数组中首次出现处的索引，若不包含此值返回-1	    List.indexOf	        符号无关
 * int lastIndexOf(prim[] array, prim target)	    给定值在数组最后出现的索引，若不包含此值返回-1	        List.lastIndexOf	    符号无关
 * prim min(prim… array)	                        数组中最小的值	                                    Collections.min     	符号相关*
 * prim max(prim… array)	                        数组中最大的值	                                    Collections.max	        符号相关
 * String join(String separator, prim… array)	    把数组用给定分隔符连接为字符串	                        Joiner.on(separator).join	符号相关
 * Comparator<prim[]>   lexicographicalComparator()	按字典序比较原生类型数组的Comparator	                Ordering.natural().lexicographical()	符号相关
 *
 * 符号无关方法存在于Bytes, Shorts, Ints, Longs, Floats, Doubles, Chars, Booleans。而UnsignedInts, UnsignedLongs, SignedBytes, 或UnsignedBytes不存在。
 * 符号相关方法存在于SignedBytes, UnsignedBytes, Shorts, Ints, Longs, Floats, Doubles, Chars, Booleans, UnsignedInts, UnsignedLongs。而Bytes不存在。
 *
 * 通用方法：
 * 方法签名	                                                描述	                                                       可用性
 * int compare(prim a, prim b)	    传统的Comparator.compare方法，但针对原生类型。JDK7的原生类型包装类也提供这样的方法	    符号相关
 * prim checkedCast(long value)	    把给定long值转为某一原生类型，若给定值不符合该原生类型，则抛出IllegalArgumentException	仅适用于符号相关的整型*
 * prim saturatedCast(long value)	把给定long值转为某一原生类型，若给定值不符合则使用最接近的原生类型值	                仅适用于符号相关的整型
 *
 *  *这里的整型包括byte, short, int, long。不包括char, boolean, float, 或double。
 *
 * 字节转换：
 *  int BYTES	常量：表示该原生类型需要的字节数
 *  prim fromByteArray(byte[] bytes)	使用字节数组的前Prims.BYTES个字节，按大字节序返回原生类型值；如果bytes.length <= Prims.BYTES，抛出IAE
 *  prim fromBytes(byte b1, …, byte bk)	接受Prims.BYTES个字节参数，按大字节序返回原生类型值
 *  byte[] toByteArray(prim value)	按大字节序返回value的字节数组
 *
 * 无符号支持：
 * 无符号包装类(UnsignedInteger和UnsignedLong)
 *                      方法签名	                                                                                                       说明
 * int UnsignedInts.parseUnsignedInt(String)long UnsignedLongs.parseUnsignedLong(String)	                                    按无符号十进制解析字符串
 * int UnsignedInts.parseUnsignedInt(String string, int radix)long UnsignedLongs.parseUnsignedLong(String string, int radix)	按无符号的特定进制解析字符串
 * String UnsignedInts.toString(int)String UnsignedLongs.toString(long)	                                                        数字按无符号十进制转为字符串
 * String UnsignedInts.toString(int   value, int radix)String UnsignedLongs.toString(long value, int radix)                 	数字按无符号特定进制转为字符串
 *
 *  方法签名	说明
 * UnsignedPrim add(UnsignedPrim), subtract, multiply, divide, remainder	简单算术运算
 * UnsignedPrim valueOf(BigInteger)	按给定BigInteger返回无符号对象，若BigInteger为负或不匹配，抛出IAE
 * UnsignedPrim valueOf(long)	按给定long返回无符号对象，若long为负或不匹配，抛出IAE
 * UnsignedPrim asUnsigned(prim value)	把给定的值当作无符号类型。例如，UnsignedInteger.asUnsigned(1<<31)的值为231,尽管1<<31当作int时是负的
 * BigInteger bigIntegerValue()	用BigInteger返回该无符号对象的值
 * toString(),  toString(int radix)	返回无符号值的字符串表示
 *
 * todo Primitives Testcase
 * Created by 波 on 2017/1/11.
 */
public class PrimitivesUtils {
}
