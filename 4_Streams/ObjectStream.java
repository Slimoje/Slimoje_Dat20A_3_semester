import javax.xml.crypto.Data;
import java.util.Date;
import java.util.stream.Stream;

public class ObjectStream {
    public static void main(String[]    args){
        //skal være et ur

        //Stream<Date> clock = Stream.generate(Date::new);

        //alternativ syntax:
        Stream<Date> clock = Stream.generate(() -> new Date());

        //clock.forEach(timestamp -> System.out.println(timestamp));
        clock.forEach(timestamp -> {
            System.out.println("And the time is: ");
            System.out.println(timestamp);
        });
    }
}
