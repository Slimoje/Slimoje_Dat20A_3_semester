import java.util.Comparator;

public class Main {
    public static void main(String[]    args){

        AbstractClass abstractClassImplemented = new AbstractClass() {
            @Override
            public void makeSurrealArt() {

            }
        };

        //implementation of a (functional) interface
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String firstString, String secondString) {
                return firstString.compareTo(secondString);
            }
        };

        //System.out.println(comparator.compare("a", "b"));

        Comparator<String> lambdaComparator = (String firstString, String secondString) -> firstString.compareTo(secondString);

        System.out.println(lambdaComparator.compare("a", "b"));

        Concatenator concat = (firstString, secondString) -> firstString + secondString;

        System.out.println(concat.cat("a", "bc"));


        /*AbstractClass abstractClassImplemented = new AbstractClass(){

            @Override
            public void makeSurrealArt() {
                System.out.println("lalala");
            }
        };

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String firstString, String secondString) {
                return firstString.compareTo(secondString);
            }
        };

        System.out.println(stringComparator.compare("Hello", "world"));

        Comparator<String> stringComparatorLambda = (String firstString, String secondString) -> firstString.compareTo(secondString);
        System.out.println(stringComparatorLambda.compare("a", "b"));*/

    }

}
