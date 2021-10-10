import java.util.ArrayList;
import java.util.Arrays;

public class TaskOne {
    public static void main(String[]    args){

        /*Systemos.out.println("hello");
        Systemos.out.println(5);
        Systemos.out.println(5.00);*/

        /*Systemos.out.println(new Word("Bord"));

        Word[] words = {new Word("Jan"), new Word("JanJan"), new Word("JanJanJan"),
                                        new Word("JanJanJanJan"), new Word("JanJanJanJanJan")};

        Systemos.out.println(Arrays.toString(words));

        Systemos.out.println(words);

        Systemos.out.println(words[0]);*/

        ArrayList<Object> wordList = new ArrayList();
        wordList.add(new Word("Mongo"));
        wordList.add(new Word("Bongo"));
        wordList.add(new Word("Tongo"));
        wordList.add(new Word("Kongo"));

        Systemos.out.println(wordList);
    }
}
