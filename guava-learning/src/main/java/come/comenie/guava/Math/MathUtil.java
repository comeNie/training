package come.comenie.guava.Math;

/**
 *
 * Guava Math 提供了一系列的运算支持。 主要处理 int、long和BigInteger、Double。
 * 对应的运算工具类为：IntMath{@link com.google.common.math.IntMath}、
 *                  LongMath{@link com.google.common.math.LongMath}、
 *                  BigIntegerMath{@link com.google.common.math.BigIntegerMath}
 *                  DoubleMath{@link com.google.common.math.DoubleMath}。
 *
 *  溢出检查：
 *
 *  IntMath.checkedAdd	        LongMath.checkedAdd
 *  IntMath.checkedSubtract	    LongMath.checkedSubtract
 *  IntMath.checkedMultiply	    LongMath.checkedMultiply
 *  IntMath.checkedPow	        LongMath.checkedPow
 *
 *  实数运算：
 *  DOWN：向零方向舍入（去尾法）
 *  UP：远离零方向舍入
 *  FLOOR：向负无限大方向舍入
 *  CEILING：向正无限大方向舍入
 *  UNNECESSARY：不需要舍入，如果用此模式进行舍入，应直接抛出ArithmeticException
 *  HALF_UP：向最近的整数舍入，其中x.5远离零方向舍入
 *  HALF_DOWN：向最近的整数舍入，其中x.5向零方向舍入
 *  HALF_EVEN：向最近的整数舍入，其中x.5向相邻的偶数舍入
 *
 *     运算                 IntMath	                        LongMath	                            BigIntegerMath
 *  除法	            divide(int, int, RoundingMode)	    divide(long, long, RoundingMode)	divide(BigInteger, BigInteger, RoundingMode)
 *  2为底的对数	    log2(int, RoundingMode)	            log2(long, RoundingMode)	        log2(BigInteger, RoundingMode)
 *  10为底的对数	    log10(int, RoundingMode)	        log10(long, RoundingMode)	        log10(BigInteger, RoundingMode)
 *  平方根	        sqrt(int, RoundingMode)	            sqrt(long, RoundingMode)	        sqrt(BigInteger, RoundingMode)
 *
 *      运算              	IntMath	                        LongMath	                            BigIntegerMath*
 *  最大公约数	    gcd(int, int)	                    gcd(long, long)	                    BigInteger.gcd(BigInteger)
 *  取模          	mod(int, int)	                    mod(long, long)	                    BigInteger.mod(BigInteger)
 *  取幂	            pow(int, int)	                    pow(long, int)	                    BigInteger.pow(int)
 *  是否2的幂	    isPowerOfTwo(int)	                isPowerOfTwo(long)	                isPowerOfTwo(BigInteger)
 *  阶乘*	        factorial(int)	                    factorial(int)	                    factorial(int)
 *  二项式系数*	    binomial(int, int)	                binomial(int, int)	                binomial(int, int)
 *
 *  DoubleMath
 *  isMathematicalInteger(double)	    判断该浮点数是不是一个整数
 *  roundToInt(double, RoundingMode)	舍入为int；对无限小数、溢出抛出异常
 *  roundToLong(double, RoundingMode)	舍入为long；对无限小数、溢出抛出异常
 *  roundToBigInteger(double, RoundingMode)	舍入为BigInteger；对无限小数抛出异常
 *  log2(double, RoundingMode)	2的浮点对数，并且舍入为int，比JDK的Math.log(double) 更快
 *
 * Created by 波 on 2017/1/18.
 */
public class MathUtil {
}
