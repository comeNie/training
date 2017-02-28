package come.comenie.guava.IO;

import com.google.common.base.Charsets;
import com.google.common.io.LineProcessor;
import com.google.common.io.Resources;

import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.CharMatcher.whitespace;
import static org.junit.Assert.*;

/**
 * Created by 波 on 2017/1/18.
 */
public class ResourcesUtilTest {

    static final String I18N
            = "\u00CE\u00F1\u0163\u00E9\u0072\u00F1\u00E5\u0163\u00EE\u00F6"
            + "\u00F1\u00E5\u013C\u00EE\u017E\u00E5\u0163\u00EE\u00F6\u00F1";

    static final String ASCII
            = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";

    @After
    public void  tearDown(){
        IoTestUtil.tearDown();
    }

    @Test
    public void testToString() throws IOException {
        URL resource = getClass().getResource("testdata/i18n.txt");
        assertEquals(I18N, Resources.toString(resource, Charsets.UTF_8));
        assertFalse(I18N.equals(Resources.toString(resource, Charsets.US_ASCII)));
    }

    @Test
    public void testToToByteArray() throws IOException {
        byte[] data = Resources.toByteArray(Resources.class.getResource(Resources.class.getSimpleName() + ".class"));
        assertEquals(0xCAFEBABE,
                new DataInputStream(new ByteArrayInputStream(data)).readInt());
    }

    @Test
    public void testCopyToOutputStream() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        URL resource = getClass().getResource("testdata/i18n.txt");
        Resources.copy(resource, out);
        assertEquals(I18N, out.toString("UTF-8"));
    }

    @Test
    public void testReadLines() throws IOException {
        URL resource = getClass().getResource("testdata/alice_in_wonderland.txt");
        List<String> lines = Resources.readLines(resource,Charsets.UTF_8);
        assertEquals(3600, lines.size());
        assertEquals("                ALICE'S ADVENTURES IN WONDERLAND", lines.get(0));
        assertEquals("                             THE END", lines.get(lines.size() - 1));
    }

    @Test
    public void testReadLines_withLineProcessor() throws IOException {
        URL resource = getClass().getResource("testdata/alice_in_wonderland.txt");
        LineProcessor<List<String>> collectAndLowercaseAndTrim =
                new LineProcessor<List<String>>() {
                    List<String> collector = new ArrayList<String>();
                    public boolean processLine(String line) {
                        collector.add(whitespace().trimFrom(line));
                        return true;
                    }

                    public List<String> getResult() {
                        return collector;
                    }
                };
        List<String> result = Resources.readLines(resource, Charsets.US_ASCII,
                collectAndLowercaseAndTrim);
        assertEquals(3600, result.size());
        assertEquals("ALICE'S ADVENTURES IN WONDERLAND", result.get(0));
        assertEquals("THE END", result.get(result.size() - 1));
    }



}