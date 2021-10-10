import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.List;

public class MethodReference {

    public MethodReference(String content){
        System.out.println(content);
    }

    public void out(String content){
        System.out.println(content);
    }
    public static void outStaticVersion(String content){
        System.out.println(content);
    }

    public static void main(String[]    args){
        List<String> greetings = Arrays.asList("Hello world", "Godmorgen", "");

        //not a method reference but a lambda
        greetings.forEach((greeting) -> System.out.println(greeting));

        //method reference
        //won't work if a custom constructor is made
        greetings.forEach(new MethodReference()::out);

        //statisk metode
        greetings.forEach(MethodReference::outStaticVersion);

        //eksempel med constructor
        greetings.forEach(MethodReference::new);
    }
}
