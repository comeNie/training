package come.comenie.guava.Basic;


import org.junit.Test;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkElementIndex;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkPositionIndex;
import static com.google.common.base.Preconditions.checkPositionIndexes;
import static com.google.common.base.Preconditions.checkState;

/**
 * Created by 波 on 2017/1/6.
 */
public class PreconditionsUtilTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCheckArgument() {
        int i = 10, j = 5;
        checkArgument( 1 > 0,"argument expected not null but .");
        checkArgument(i < j, "Expected i < j, but %s > %s", i, j);
    }

    @Test(expected = NullPointerException.class)
    public  void testCheckNotNull(){
        checkNotNull(null,"argument shoul not be null");
    }

    @Test(expected = IllegalStateException.class)
    public  void  testCheckState(){
        checkState(false,"state should be true");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCheckElementIndex(){

        checkElementIndex(10,5,"out of  bounds");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCheckPositionIndex(){
        checkPositionIndex(10,9,"out of bounds");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCheckPositionIndexes() {
        checkPositionIndexes(5,10,7);
    }

}