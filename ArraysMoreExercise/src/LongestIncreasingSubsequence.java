import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] num = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int[] len = new int[num.length];
        int[] prev = new int[num.length];
        int maxLength = 0;
        int lastIndex = -1;
        for (int i = 0; i < num.length; i++) {
            len[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (num[j] < num[i] && len[j] + 1 > len[i]) {
                    len[i] = 1 + len[j];
                    prev[i] = j;
                }
            }
            if (maxLength < len[i]) {
                maxLength = len[i];
                lastIndex = i;
            }
        }
        int[] lis = new int[maxLength];

        for (int i = maxLength - 1; i >= 0; i--) {

            lis[i] = num[lastIndex];
            lastIndex = prev[lastIndex];
        }
        for (int i = 0; i < maxLength; i++) {
            System.out.print(lis[i] + " ");
        }
    }
}
