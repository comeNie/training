package come.comenie.guava.IO;

/**
 * 资源处理Resources {@link com.google.common.io.Resources}
 *
 * 提供了资源读取，操作的工具。
 *
 * 读取Resource:  URL getResource(String resourceName),  URL getResource(Class<?> contextClass, String resourceName)
 * 将Resource 转换成 ByteSource asByteSource() , CharSource asCharSource(),byte[] toByteArray(),String toString()
 * 复制操作：  copy
 * 读取操作：
 *  readLines(URL url, Charset charset)，
 *  <T> T readLines(URL url, Charset charset,LineProcessor<T> callback)
 *
 * Created by 波 on 2017/1/18.
 */
public class ResourcesUtil {
}
