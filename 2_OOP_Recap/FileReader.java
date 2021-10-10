import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static List<String> readFile(String fileName) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        List<String> list = new ArrayList<>();
        while(scan.hasNextLine()) {
            list.add(scan.nextLine());
        }
        return list;
    }

}
