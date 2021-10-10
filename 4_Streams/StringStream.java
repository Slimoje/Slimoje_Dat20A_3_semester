import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringStream {
    public static void main(String[]    args){
        List<String> coolWords = Arrays.asList("Jan", "JanJan", "Sejt", "mongo", "bongo", "kongo"
                                                , "fongo", "", "", "Jan", "mongo", "ost", "ost");

        List<String> onlyWords = coolWords.stream().filter(word -> !word.isEmpty()).collect(Collectors.toList());
        System.out.println(onlyWords);

        //int vocabulary = coolWords.stream().filter(word -> !word.isEmpty()).distinct().collect(Collectors.toList()).size();
        int vocabulary = (int) coolWords.stream().filter(word -> !word.isEmpty()).distinct().count();

        System.out.println(vocabulary);

        String sentence = coolWords
                            .parallelStream()
                            .filter(word -> !(word.equals("")))
                            .collect(Collectors.joining(" ")) + ".";

        System.out.println(sentence);


    }
}
