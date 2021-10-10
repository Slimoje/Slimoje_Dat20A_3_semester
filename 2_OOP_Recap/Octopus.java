import java.util.Random;

import static java.lang.Thread.sleep;

public class Octopus extends Animal{

    @Override
    public String move(){
        return "Swish Swosh";
    }
        static final Random rand = new Random();
        static final int min = 1;
        static final int max = 10;


    public void makeDoActivity(){
        boolean go = true;
        while(go){
            System.out.println(selectActivity());
            try {
                String activity = selectActivity();
                System.out.println(activity);
                if(activity.equals("Mate")){
                    GameOfOctopus gameThread = new GameOfOctopus();
                    gameThread.start();
                }
                sleep(1000);
            } catch(InterruptedException ex){
                System.out.println("Hold up");
            }
        }
    }

    private String selectActivity(){
        String activity = "";

        /*int randomNumber = rand.nextInt(max)+min;
        int randomNumber2 = rand.nextInt(max)+min;*/
        switch(rand.nextInt(max)+min){
            case 1:
                activity = "Multi-wave";
                break;
            case 2:
                activity = "Deep dive get away";
                break;
            case 3:
                activity = "Menacing tentacles";
                break;
            case 4:
                activity = "Suckamok";
                break;
            case 5:
                activity = "Bleech beach";
                break;
            case 6:
                activity = "Squid Attack";
                break;
            case 7:
                activity = "DoomSquid";
                break;
            case 8:
                activity = "zzzzz";
                break;
            case 9:
                activity = "Slapapapapapap";
                break;
            case 10:
                activity = "Mate";
                break;
            default:
                activity = "Nothing happened.";
                break;
        }return activity;
    }
    /*public int getRandom(int lower, int upper){
        Random randoe = new Random();
        return randoe.nextInt(lower+upper);
    }*/
}
