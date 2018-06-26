package programs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseString {

    public String spinWords(String sentence) {
        //TODO: Code stuff here
        String[] words = sentence.split(" ");

        String newWord = new String();
        int wordLength = words.length;
        for(String word : words){
            if(word.length() < 5){
                newWord= newWord+word;
            }else{
                int length = word.length();
                char[] actual = word.toCharArray();
                char[] reverse = new char[length];
                int j = length - 1;
                for (int i=0; i  < length ; i++){
                    reverse[j] = actual[i];
                    j--;
                }
                newWord = newWord+String.valueOf(reverse);
            }
            if (wordLength > 1){
                newWord = newWord+" ";
                wordLength--;
            }
        }
        System.out.println(newWord);
        return newWord;

    }

    /*public static void main(String[] args) {
        ReverseString rev = new ReverseString();
        String sentence = "This is me";
        System.out.println(sentence);
        String rever = rev.spinWords(sentence);
        System.out.println(rever);
    }*/

    @Test
    public void test() {
        Assertions.assertEquals("emocleW", new ReverseString().spinWords("Welcome"));
        Assertions.assertEquals("Hey wollef sroirraw", new ReverseString().spinWords("Hey fellow warriors"));
    }
}
