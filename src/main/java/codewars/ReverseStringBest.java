package codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseStringBest {


  /*  public String SpinWord(String sentence){
        List<String> result = new ArrayList<>();
        Stream<String> words = Arrays.stream(sentence.split(" "));
        for (String word : words)
            result.add(word.length()>5? String.valueOf(new StringBuffer(word).reverse()) :word);

        return result;
    }*/

    public String spingWords(String sentence){
        return Arrays.stream(sentence.split(" "))
                .map(i -> i.length() > 4? new StringBuffer(i).reverse().toString():i)
                .collect(Collectors.joining(" "));
    }

    @Test
    public void test() {
        Assertions.assertEquals("emocleW", new ReverseString().spinWords("Welcome"));
        Assertions.assertEquals("Hey wollef sroirraw", new ReverseString().spinWords("Hey fellow warriors"));
    }

}
