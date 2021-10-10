package HandMaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//fortæller det er springboot app og at det her er main metoden
//kunne have heddet "@SpringbootMain"
@SpringBootApplication
public class HandMaven {
    public static void main(String[]    args) {
        //Main metoden gives til spring (IoC)
        SpringApplication.run(HandMaven.class, args);
    }
}
