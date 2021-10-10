import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Octopus extends Animal{

    static final Random rand = new Random();
    static final int min = 1;
    static final int max = 10;
    static int count = 1;
    static List<GameOfOctopus> threadList = new ArrayList<>();
    String name;

    public Octopus(String name){
        this.name = name;
        System.out.println(name + " was born!");
    }

    @Override
    public String move(){
        return "Swish Swosh";
    }

    public void makeDoActivity(){
        while(count <= 1337){
            try {
                String activity = selectActivity();
                System.out.println(this.name + " " +activity);
                if(activity.equals("Mate")) {
                    int numberOfSquids = rand.nextInt(3)+1;
                    switch(numberOfSquids) {
                        case 1: {
                            System.out.println("Lonely star!");
                            GameOfOctopus gameThread = new GameOfOctopus();
                            gameThread.start();
                            threadList.add(gameThread);
                            count ++;
                            System.out.println("The group now contains "+ count +" squids");
                            if (count >= 1337) {
                                gameThread.join();
                            }
                            if(count > 500) {
                                System.out.println("The giant pack of squids caught the attention of several sharks!");
                                int pendingSharkAttack = rand.nextInt(4);
                                if(pendingSharkAttack <= 2) {
                                    System.out.println(this.name + " was taken!");
                                    gameThread.join();
                                }
                            }
                        }
                            break;

                        case 2: {
                            System.out.println("Twins! Double trouble!");
                            GameOfOctopus gameThread = new GameOfOctopus();
                            GameOfOctopus gameThread2 = new GameOfOctopus();
                            gameThread.start();
                            gameThread2.start();
                            threadList.add(gameThread);
                            threadList.add(gameThread2);
                            count += 2;
                            System.out.println("The group now contains "+ count +" squids");
                            if (count >= 1337) {
                                gameThread.join();
                                gameThread2.join();
                            }
                            if(count > 500) {
                                System.out.println("The giant pack of squids caught the attention of several sharks!");
                                int pendingSharkAttack = rand.nextInt(4);
                                if(pendingSharkAttack <= 2) {
                                    System.out.println(this.name + "and the twin was taken!");
                                    gameThread.join();
                                    gameThread2.join();
                                }
                            }
                        }
                            break;

                        case 3: {
                            System.out.println("Triplings! Lucky number!");
                            GameOfOctopus gameThread = new GameOfOctopus();
                            GameOfOctopus gameThread2 = new GameOfOctopus();
                            GameOfOctopus gameThread3 = new GameOfOctopus();
                            gameThread.start();
                            gameThread2.start();
                            gameThread3.start();
                            count += 3;
                            threadList.add(gameThread);
                            threadList.add(gameThread2);
                            threadList.add(gameThread3);
                            System.out.println("The group now contains "+ count +" squids");
                            if (count >= 1337) {
                                gameThread.join();
                                gameThread2.join();
                                gameThread3.join();
                            }
                            if(count > 500) {
                                System.out.println("The giant pack of squids caught the attention of several sharks!");
                                int pendingSharkAttack = rand.nextInt(4);
                                if(pendingSharkAttack <= 2) {
                                    System.out.println(this.name + " and newest sipplings were taken!");
                                    gameThread.join();
                                    gameThread2.join();
                                    gameThread3.join();
                                }
                            }
                        }
                            break;
                        default:
                            break;
                    }
                }
                if(activity.equals("zzzzz")) {
                    System.out.println(this.name + " is very sleepy and slow");
                    sleep(7500);
                }
                if(count >= 800) {
                    int blueWhale = rand.nextInt(100)+1;
                    if(blueWhale == 100) {
                        System.out.println("A blue whale is eating everyone!");
                        for (int i = 0; i < threadList.size(); i++) {
                            threadList.get(i).join();
                            count = 1337;
                        }
                    }
                }

                sleep(1000);
            } catch(InterruptedException ex){
                System.out.println("Hold up");
            }

        }
        System.out.println(GameOfOctopus.activeCount() + " squids remains.");
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
