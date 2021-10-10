import java.util.ArrayList;

public class Systemos {

    public static class out{
        public static void println(int integerToPrint){
            System.out.println(integerToPrint);
        }
        public static void println(String stringToPrint){
            System.out.println(stringToPrint);
        }
        public static void println(double doubleToPrint){
            System.out.println(doubleToPrint);
        }
        public static void println(boolean booleanToPrint){
            System.out.println(booleanToPrint);
        }
        public static void println(char charToPrint){
            System.out.println(charToPrint);
        }
        public static void println(byte byteToPrint){
            System.out.println(byteToPrint);
        }
        public static void println(long longToPrint){
            System.out.println(longToPrint);
        }
        public static void println(short shortToPrint){
            System.out.println(shortToPrint);
        }
        public static void println(float floatToPrint){
            System.out.println(floatToPrint);
        }
        /*public static void println(Word wordToPrint){
            System.out.println(wordToPrint);
        }*/
        /*public static void println(Object content){
            System.out.println(content);
        }*/
        /*public static void println(Object[] arrayToPrint){
            for(Object o: arrayToPrint){
                println(o);
            };
        }*/
        public static void println(ArrayList<Object> content){
            for(Object object: content){
                System.out.println(object);
            }
        }
    }

}
