public class GameOfOctopus extends Thread{

    @Override
    public void run() {
        System.out.println("Run has been called");

        Octopus Otto = new Octopus();
        Otto.makeDoActivity();
    }
}
