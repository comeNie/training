package come.comenie.guava.IO;

import com.google.common.collect.Sets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Set;


/**
 * Created by 波 on 2017/1/18.
 */
public class IoTestUtil {

    private static  File testDir;

    private static File tempDir;

    private final  static  Set<File> filesToDelete = Sets.newHashSet();


    public  static  File getTestDir() throws IOException {
        if(null != testDir){
            return  testDir;
        }
        URL testFileUrl = IoTestUtil.class.getResource("testdata/i18n.txt");
        if (testFileUrl == null) {
            throw new RuntimeException("unable to locate testdata directory");
        }
        if (testFileUrl.getProtocol().equals("file")) {
            try {
                File testFile = new File(testFileUrl.toURI());
                testDir = testFile.getParentFile(); // the testdata directory
            } catch (Exception ignore) {
                // probably URISyntaxException or IllegalArgumentException
                // fall back to copying URLs to files in the testDir == null block below
            }
        }

        if (testDir == null) {
            // testdata resources aren't file:// urls, so create a directory to store them in and then
            // copy the resources to the filesystem as needed
            testDir = createTempDir();
        }
        return testDir;
    }

    public static final File createTempDir() throws IOException {
        File tempFile = File.createTempFile("IoTestCase", "");
        if (!tempFile.delete() || !tempFile.mkdir()) {
            throw new IOException("failed to create temp dir");
        }
        filesToDelete.add(tempFile);
        return tempFile;
    }
    public final static File getTempDir() throws IOException {
        if (tempDir == null) {
            tempDir = createTempDir();
        }

        return tempDir;
    }


    public final static File createTempFile() throws IOException {
        return File.createTempFile("test", null, getTempDir());
    }

    public final static File getTestFile(String name) throws IOException {
        File file = new File(getTestDir(), name);
        if (!file.exists()) {
            URL resourceUrl = IoTestUtil.class.getResource("testdata/" + name);
            if (resourceUrl == null) {
                return null;
            }
            copy(resourceUrl, file);
        }

        return file;
    }


    public static void tearDown(){
        for (File file : filesToDelete) {
            if (file.exists()) {
                delete(file);
            }
        }
        filesToDelete.clear();
    }

    private static void copy(URL url, File file) throws IOException {
        InputStream in = url.openStream();
        try {
            OutputStream out = new FileOutputStream(file);
            try {
                byte[] buf = new byte[4096];
                for (int read = in.read(buf); read != -1; read = in.read(buf)) {
                    out.write(buf, 0, read);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    private static boolean  delete(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (!delete(f)) {
                        return false;
                    }
                }
            }
        }

        if (!file.delete()) {
            return false;
        }

        return true;
    }
}
