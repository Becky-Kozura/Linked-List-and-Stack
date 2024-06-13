import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        try {
            File myFile = new File("integers.txt");
            Scanner newReader = new Scanner(myFile);
            while (newReader.hasNextLine()) {
                String data = newReader.nextLine();
                System.out.println(data);
            }
            newReader.close();
        } catch (FileNotFoundException err) {
            System.out.println("An error occurred.");
            err.printStackTrace();
        }
    }
}
