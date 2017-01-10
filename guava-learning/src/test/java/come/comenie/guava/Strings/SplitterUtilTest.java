package come.comenie.guava.Strings;

import com.google.common.base.Splitter;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 波 on 2017/1/9.
 */
public class SplitterUtilTest {

    @Test
    public void testSplitterByChar() {
        Assert.assertArrayEquals(new String[]{"1","2"}, Splitter.on(",").splitToList("1,2").toArray());
    }

    @Test
    public void testSplitterByCharWithSpace(){
        Assert.assertArrayEquals(new String[]{"1","2"}, Splitter.on(",").trimResults().splitToList("1,2 ").toArray());
    }

    @Test
    public  void testSplitterByString(){
        Assert.assertArrayEquals(new String[]{"1","2"},Splitter.on(",&").trimResults().splitToList("1,&2 ").toArray());
    }

    @Test
    public void testSplitterByPattern(){

    }
    @Test
    public void testSplitterByPattern2(){

    }

    @Test
    public  void testSplitterByCharMatcher(){

    }

    @Test
    public  void testSplitterByFixLength(){
        Assert.assertArrayEquals(new String[]{"1","2"}, Splitter.fixedLength(1).trimResults().omitEmptyStrings().splitToList("12 ").toArray());
    }


    @Test
    public  void testSplitterByFixLengthWithLimit(){
        Assert.assertArrayEquals(new String[]{"1","2","5","6","67446563242342342"}, Splitter.fixedLength(1).limit(5).splitToList("125667446563242342342").toArray());
    }






}