
import java.util.Scanner;
public class TheSecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String str = scanner.nextLine();
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            System.out.println(c);
        }
        scanner.close();
    }
}
