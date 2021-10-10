import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[]    args) throws InterruptedException {

            GameOfOctopus game = new GameOfOctopus();
            Octopus.threadList.add(game);

            game.start();
            game.join();

            if (GameOfOctopus.activeCount() <= 100) {
                System.out.println("The pack reached " + Octopus.count + " squids\nNothing lasts forever");
                for (int i = 0; i < Octopus.threadList.size(); i++) {
                    Octopus.threadList.get(i).join();
                }
            }
    }
}
