package programs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareDigit {

    public int squareDigits(int n) {
        // TODO Implement me

        String result=new String();
        int cal ;

        while(n > 0){

            cal = n%10;
            cal = cal*cal;
            result = String.valueOf(cal) + result;
            n= n/10;
        }

        return Integer.parseInt(result);

    }

    @Test
    public void squareTest(){
        Assertions.assertEquals(811181, new SquareDigit().squareDigits(9119));
    }
}
