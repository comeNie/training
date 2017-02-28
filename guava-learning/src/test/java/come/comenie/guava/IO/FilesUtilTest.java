package come.comenie.guava.IO;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.ByteProcessor;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import com.google.common.primitives.Bytes;

import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import static come.comenie.guava.IO.IoTestUtil.createTempFile;
import static come.comenie.guava.IO.IoTestUtil.getTestFile;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by 波 on 2017/1/18.
 */
public class FilesUtilTest {

    @Test
    public void testCopyMove() throws IOException {
        File file = getTestFile("i18n.txt");
        File temp1 = createTempFile();
        File temp2 = createTempFile();
        Files.copy(file,temp1);
        assertTrue(Files.equal(file,temp1));
        Files.move(temp1,temp2);
        assertTrue(Files.equal(file,temp2));
    }

    @Test
    public void testGetFileExtension() {
        assertEquals("txt", Files.getFileExtension(".txt"));
        assertEquals("txt", Files.getFileExtension("blah.txt"));
        assertEquals("txt", Files.getFileExtension("blah..txt"));
        assertEquals("txt", Files.getFileExtension(".blah.txt"));
        assertEquals("txt", Files.getFileExtension("/tmp/blah.txt"));
        assertEquals("gz", Files.getFileExtension("blah.tar.gz"));
        assertEquals("", Files.getFileExtension("/"));
        assertEquals("", Files.getFileExtension("."));
        assertEquals("", Files.getFileExtension(".."));
        assertEquals("", Files.getFileExtension("..."));
        assertEquals("", Files.getFileExtension("blah"));
        assertEquals("", Files.getFileExtension("blah."));
        assertEquals("", Files.getFileExtension(".blah."));
        assertEquals("", Files.getFileExtension("/foo.bar/blah"));
        assertEquals("", Files.getFileExtension("/foo/.bar/blah"));
    }

    @Test
    public void testEquals() throws IOException {
        File asciiFile = getTestFile("ascii.txt");
        File i18nFile = getTestFile("i18n.txt");
        assertFalse(Files.equal(asciiFile, i18nFile));
        assertTrue(Files.equal(asciiFile, asciiFile));

        File temp = createTempFile();
        Files.copy(asciiFile, temp);
        assertTrue(Files.equal(asciiFile, temp));

        Files.copy(i18nFile, temp);
        assertTrue(Files.equal(i18nFile, temp));

        Files.copy(asciiFile, temp);
        RandomAccessFile rf = new RandomAccessFile(temp, "rw");
        rf.writeByte(0);
        rf.close();
        assertEquals(asciiFile.length(), temp.length());
        assertFalse(Files.equal(asciiFile, temp));

        assertTrue(Files.asByteSource(asciiFile)
                .contentEquals(Files.asByteSource(asciiFile)));
    }

    @Test
    public void testTouch() throws IOException {
        File temp = createTempFile();
        assertTrue(temp.exists());
        assertTrue(temp.delete());
        assertFalse(temp.exists());
        Files.touch(temp);
        assertTrue(temp.exists());
        Files.touch(temp);
        assertTrue(temp.exists());

        try {
            Files.touch(new File(temp.getPath()) {
                @Override
                public boolean setLastModified(long t) {
                    return false;
                }

                private static final long serialVersionUID = 0;
            });
            fail("expected exception");
        } catch (IOException expected) {
        }
    }

    @Test
    public void testPredicates() throws IOException {
        File asciiFile = getTestFile("ascii.txt");
        File dir = asciiFile.getParentFile();
        assertTrue(Files.isDirectory().apply(dir));
        assertFalse(Files.isFile().apply(dir));

        assertFalse(Files.isDirectory().apply(asciiFile));
        assertTrue(Files.isFile().apply(asciiFile));
    }

    @Test
    public void testLineReading() throws IOException {
        File temp = createTempFile();
        assertNull(Files.readFirstLine(temp, Charsets.UTF_8));
        assertTrue(Files.readLines(temp, Charsets.UTF_8).isEmpty());

        PrintWriter w = new PrintWriter(Files.newWriter(temp, Charsets.UTF_8));
        w.println("hello");
        w.println("");
        w.println(" world  ");
        w.println("");
        w.close();

        assertEquals("hello", Files.readFirstLine(temp, Charsets.UTF_8));
        assertEquals(ImmutableList.of("hello", "", " world  ", ""),
                Files.readLines(temp, Charsets.UTF_8));

        assertTrue(temp.delete());
    }

    @Test
    public void testReadLines_withLineProcessor() throws IOException {
        File temp = createTempFile();
        LineProcessor<List<String>> collect = new LineProcessor<List<String>>() {
            List<String> collector = new ArrayList<String>();

            public boolean processLine(String line) {
                collector.add(line);
                return true;
            }

            public List<String> getResult() {
                return collector;
            }
        };
        assertTrue(Files.readLines(temp, Charsets.UTF_8, collect).isEmpty());

        PrintWriter w = new PrintWriter(Files.newWriter(temp, Charsets.UTF_8));
        w.println("hello");
        w.println("");
        w.println(" world  ");
        w.println("");
        w.close();
        Files.readLines(temp, Charsets.UTF_8, collect);
        assertArrayEquals(collect.getResult().toArray(),new String[]{"hello", "", " world  ", ""});


        LineProcessor<List<String>> collectNonEmptyLines =
                new LineProcessor<List<String>>() {
                    List<String> collector = new ArrayList<String>();

                    public boolean processLine(String line) {
                        if (line.length() > 0) {
                            collector.add(line);
                        }
                        return true;
                    }

                    public List<String> getResult() {
                        return collector;
                    }
                };
        Files.readLines(temp, Charsets.UTF_8, collectNonEmptyLines);
        assertArrayEquals(collectNonEmptyLines.getResult().toArray(),new String[]{"hello",  " world  ", });
        assertTrue(temp.delete());
    }

    @Test
    public void testReadBytes() throws IOException {
        ByteProcessor<byte[]> processor = new ByteProcessor<byte[]>() {
            private final ByteArrayOutputStream out = new ByteArrayOutputStream();

            public boolean processBytes(byte[] buffer, int offset, int length) throws IOException {
                if (length >= 0) {
                    out.write(buffer, offset, length);
                }
                return true;
            }

            public byte[] getResult() {
                return out.toByteArray();
            }
        };

        File asciiFile = getTestFile("ascii.txt");
        byte[] result = Files.readBytes(asciiFile, processor);
        assertEquals(Bytes.asList(Files.toByteArray(asciiFile)), Bytes.asList(result));
    }




    @After
    public void  tearDown(){
        IoTestUtil.tearDown();
    }

}