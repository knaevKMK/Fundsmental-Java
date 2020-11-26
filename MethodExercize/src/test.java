import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        List<Integer> list = Arrays.stream(in.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int[] n = Arrays.stream(in.split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("end")) {

            switch (input[0]) {
                case "exchange":
                    int index = Integer.parseInt(input[1]);

                    if (0 <= index && index < list.size()) {
                        letExchangeArray(n, index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "max":
                case "min":
                    List<Integer> sub = getNums(list, input[1]);

                    if (!sub.isEmpty()) {

                        if (input[0].equals("max")) {
                            System.out.println(list.lastIndexOf(Collections.max(sub)));
                        } else {
                            System.out.println(list.lastIndexOf(Collections.min(sub)));
                        }

                    } else {
                        System.out.println("No matches");
                    }
                    break;

                case "first":
                case "last":
                    int count = Integer.parseInt(input[1]);

                    if (count <= list.size()) {
                        sub = getNums(list, input[2]);

                        if (input[0].equals("first")) {
                            System.out.println(sub.stream().limit(count).collect(Collectors.toList()));
                        } else {
                            printLast(sub, count);
                        }

                    } else {
                        System.out.println("Invalid count");
                    }
                    break;
            }

            input = scanner.nextLine().split(" ");
        }

        System.out.println(list);
    }

    private static void printLast(List<Integer> sub, int count) {
        Collections.reverse(sub);
        sub = sub.stream().limit(count).collect(Collectors.toList());
        Collections.reverse(sub);
        System.out.println(sub);
    }

    private static List<Integer> getNums(List<Integer> list, String s) {
        int num;
        if (s.equals("even")) {
            num = 0;
        } else {
            num = 1;
        }
        return list.stream().filter(n -> n % 2 == num).collect(Collectors.toList());
    }

    private static void printMax(int[] n, String tokenEvenOdd) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        if (tokenEvenOdd.equals("odd")) {
            for (int i = 0; i < n.length; i++) {
                if (n[i] % 2 != 0) {
                    if (n[i] >= max) {
                        max = n[i];
                        index = i;
                    }
                }
            }
        } else if (tokenEvenOdd.equals("even")) {
            for (int i = 0; i < n.length; i++) {
                if (n[i] % 2 == 0) {
                    if (n[i] >= max) {
                        max = n[i];
                        index = i;
                    }
                }
            }
        }
        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }

    private static void printMin(int[] n, String tokenEvenOdd) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        if (tokenEvenOdd.equals("odd")) {
            for (int i = 0; i < n.length; i++) {
                if (n[i] % 2 != 0) {
                    if (n[i] <= min) {
                        min = n[i];
                        index = i;
                    }
                }
            }
        } else if (tokenEvenOdd.equals("even")) {
            for (int i = 0; i < n.length; i++) {
                if (n[i] % 2 == 0) {
                    if (n[i] <= min) {
                        min = n[i];
                        index = i;
                    }
                }
            }
        }
        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }

    public static int[] oddInArray(int[] n) {
        int countOdd = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] % 2 != 0) {
                countOdd++;
            }
        }
        int[] odd = new int[countOdd];
        int positionOdd = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] % 2 != 0) {
                odd[positionOdd] = n[i];
                positionOdd++;
            }
        }
        return odd;
    }

    public static int[] evenInArray(int[] n) {
        int countEven = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] % 2 == 0) {
                countEven++;
            }
        }
        int[] even = new int[countEven];
        int positioEven = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] % 2 == 0) {
                even[positioEven] = n[i];
                positioEven++;
            }
        }
        return even;
    }

    private static void letExchangeArray(int[] n, int index) {
        int count = 0;
        int[] nNew = n.clone();
        for (int i = 0; i < n.length; i++) {
            if (index + 1 + i < n.length) {
                n[i] = nNew[index + i + 1];
            } else {
                n[i] = nNew[count];
                count++;
            }
        }
    }

}
