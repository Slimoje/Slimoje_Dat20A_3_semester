
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameOfOctopus extends Thread{
    public static List<String> names = new ArrayList<>();

    static {
        try{
            names = FileReader.readFile("names");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Random rand = new Random();
    @Override
    public void run() {

        Octopus Otto = new Octopus(names.get(rand.nextInt(names.size())));
        Otto.makeDoActivity();
    }
}
