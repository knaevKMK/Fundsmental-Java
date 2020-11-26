import java.util.Scanner;

public class ReverseArrayofStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] arr = input.split(" ");
        String reverse = "";

        for (int i = arr.length - 1; i >= 0; i--) {
            reverse = reverse + arr[i] + " ";
        }
        System.out.println(reverse);
    }
}
