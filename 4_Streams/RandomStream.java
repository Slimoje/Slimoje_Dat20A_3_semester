import java.util.Random;

public class RandomStream {
    public static void main(String[]    args){
        Random random = new Random();
        //System.out.println(random.nextInt());
        random.ints().forEach(System.out::println);
        //random.ints().forEach((number) -> System.out.println(number));
    }
}
