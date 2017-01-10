package come.comenie.guava.Basic;

import com.google.common.base.Optional;

import org.junit.Test;

/**
 * Created by 波 on 2017/1/6.
 */
public class OptionalUtilTest {

    @Test
    public void testOptional(){
        com.google.common.base.Optional<Integer> optional = Optional.of(10);
        if(optional.isPresent()){
            System.out.println("optional is Present :" + optional.isPresent());
            System.out.println("optional value :" + optional.get());
        }

    }

    @Test(expected = IllegalStateException.class)
    public void  testNullOptional(){
        Optional<Integer> nullable = Optional.fromNullable(null);
        if(nullable.isPresent()){
            System.out.println("optional is Present :" + nullable.isPresent());
            System.out.println("optional value :" + nullable.get());
        }
        nullable.get();
    }
}