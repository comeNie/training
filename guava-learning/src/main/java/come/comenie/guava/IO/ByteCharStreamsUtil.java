package come.comenie.guava.IO;

/**
 *
 * 字节流{@link com.google.common.io.ByteStreams}字符流{@link com.google.common.io.CharStreams}工具集
 *          ByteStreams	                            CharStreams
 * byte[] toByteArray(InputStream)	        String toString(Readable)
 *           N/A	                        List<String> readLines(Readable)
 * long copy(InputStream, OutputStream)	    long copy(Readable, Appendable)
 * void readFully(InputStream, byte[])	                N/A
 * void skipFully(InputStream, long)	    void skipFully(Reader, long)
 * OutputStream nullOutputStream()	        Writer nullWriter()
 *
 * 在ByteStreams、CharStreams以及com.google.common.io包中的一些其他类中，某些方法仍然在使用InputSupplier和OutputSupplier接口。
 * 这两个借口和相关的方法是不推荐使用的：它们已经被下面描述的source和sink类型取代了，并且最终会被移除。
 * Created by 波 on 2017/1/18.
 */
public class ByteCharStreamsUtil {
}
