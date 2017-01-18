package come.comenie.guava.IO;

/**
 *
 * Guava 抽象流。  主要包含流(Source)和汇(Sink)。源是可读的，汇是可写的.
 * 源与汇API的好处是它们提供了通用的一组操作。比如，一旦你把数据源包装成了ByteSource，无论它原先的类型是什么，你都得到了一组按字节操作的方法。
 *
 *  	  字节	                                                    字符
 * 读 	ByteSource{@link com.google.common.io.ByteSource} 	    CharSource{@link com.google.common.io.CharSource}
 * 写	ByteSink{@link com.google.common.io.ByteSink} 	        CharSink {@link com.google.common.io.CharSink}
 *
 * 源和汇实现：
 *          字节	                                            字符
 *  Files.asByteSource(File)	                Files.asCharSource(File, Charset)
 *  Files.asByteSink(File, FileWriteMode...)	Files.asCharSink(File, Charset, FileWriteMode...)
 *  Resources.asByteSource(URL)	                Resources.asCharSource(URL, Charset)
 *  ByteSource.wrap(byte[])	                    CharSource.wrap(CharSequence)
 *  ByteSource.concat(ByteSource...)	        CharSource.concat(CharSource...)
 *  ByteSource.slice(long, long)	                N/A
 *      N/A	                                    ByteSource.asCharSource(Charset)
 *      N/A	                                    ByteSink.asCharSink(Charset)
 *
 *
 * 通用操作：
 * openStream()：根据源与汇的类型，返回InputStream、OutputStream、Reader或者Writer。
 * openBufferedStream()：根据源与汇的类型，返回InputStream、OutputStream、BufferedReader或者BufferedWriter。
 * 返回的流保证在必要情况下做了缓冲。例如，从字节数组读数据的源就没有必要再在内存中作缓冲，这就是为什么该方法针对字节源不返回BufferedInputStream。
 * 字符源属于例外情况，它一定返回BufferedReader，因为BufferedReader中才有readLine()方法。
 *
 * 源操作：
 * 字节源	                                        字符源
 * byte[]   read()	                        String   read()
 * N/A	                                    ImmutableList<String>   readLines()
 * N/A	                                    String   readFirstLine()
 * long  copyTo(ByteSink)	                long   copyTo(CharSink)
 * long   copyTo(OutputStream)	            long   copyTo(Appendable)
 * long   size() (in bytes)                     	N/A
 * boolean   isEmpty()	                    boolean   isEmpty()
 * boolean   contentEquals(ByteSource)	            N/A
 * HashCode   hash(HashFunction)	                N/A
 *
 * 汇操作：
 *
 * 字节汇	                                        字符汇
 * void write(byte[])	                    void write(CharSequence)
 * long writeFrom(InputStream)          	long writeFrom(Readable)
 * N/A	                                    void writeLines(Iterable<? extends CharSequence>)
 * N/A	                                    void writeLines(Iterable<? extends CharSequence>, String)
 *
 * Created by 波 on 2017/1/18.
 */
public class SourceSinkUtil {
}
