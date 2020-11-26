import java.util.Scanner;

public class EncryptSortPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] list = new int[n];
        char[] vowel = {'a', 'e', 'i', 'o', 'u', 'A','E','I','O','U'};

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("");
            int code = 0;

            for (int j = 0; j < input.length; j++) { // // Криптирайте всеки низ чрез сумиране:
                char ch = input[j].charAt(0);
                boolean voice = false;

                for (int k = 0; k < vowel.length; k++) {
                    if (ch == vowel[k]) {
                        code = code + ch * input.length;
                        voice = true;
                        break;//• Кодът на всяка гласна, умножена по дължината на низа
                    }
                }
                if (!voice) {
                    code = code + ch / input.length;        //• Кодът на всеки съгласен, разделен на дължината на низа
                }
            }
            list[i] = code;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int check = 0;
                if (list[j] < list[i]) {
                    check = list[i];
                    list[i] = list[j];
                    list[j] = check;
                }
            }
        }
        //Сортирайте числовата последователност във възходящ ред и я отпечатайте на конзолата.
        for (int i = 0; i < n; i++) {
            System.out.println(list[i] + " ");
        }
    }
}
