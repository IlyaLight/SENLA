import java.util.Scanner;

public class TextIn {
    static String getText(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        return s;
    }
}
