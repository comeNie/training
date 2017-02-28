package come.comenie.guava.IO;

import com.google.common.io.FileWriteMode;

/**
 * Files {@link com.google.common.io.Files} 封装了一些列的文件相关操作。
 *
 *
 *
 *
 * 文件相关操作：
 * touch()
 * move()
 * copy()
 * createTempDir()
 * createParentDirs(File file)
 * equal()
 *
 *
 * 转换为流操作：
 *  BufferedReader newReader()
 *  BufferedWriter newWriter()
 *  ByteSource asByteSource()
 *  ByteSink{@link com.google.common.io.ByteSink} asByteSink() {@link FileWriteMode}
 *  CharSource asCharSource()
 *  CharSink asCharSink()
 *  MappedByteBuffer map()
 *
 * 文件读写：
 * write()
 * append()
 * readFirstLine()
 * readLines()
 * readBytes()
 *
 * 文件信息：
 * String simplifyPath()
 * String getFileExtension()
 * String getNameWithoutExtension()
 * HashCode hash()
 *

 * 判断文件是否为目录：
 * Files.isDirectory()
 * Files.isFile()
 *
 *
 * Created by 波 on 2017/1/18.
 */
public class FilesUtil {
}
