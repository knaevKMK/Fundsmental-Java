import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] n = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] token = command.split(" ");
            if ("exchange".equals(token[0])) {
                int index = Integer.parseInt(token[1]);
                if (index < n.length && index >= 0) {
                    letExchangeArray(n, index);
                } else {
                    System.out.println("Invalid index");
                }
            } else if ("min".equals(token[0])) {
                String tokenEvenOdd = token[1];
                printMin(n, tokenEvenOdd);
            } else if ("max".equals(token[0])) {
                String tokenEvenOdd;
                tokenEvenOdd = token[1];
                printMax(n, tokenEvenOdd);
            } else if ("first".equals(token[0]) || "last".equals(token[0])) {
                String tokenEvenOdd;
                String one = token[0];
                int pcs = Integer.parseInt(token[1]);
                tokenEvenOdd = token[2];
                if (n.length >= pcs) {
                    printLastOrFirst(n, one, pcs, tokenEvenOdd);
                } else {
                    System.out.println("Invalid count");
                }
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < n.length; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            if (i < n.length - 1) {
                System.out.print(n[i] + ", ");
            }
            if (i == n.length - 1) {
                System.out.print(n[i] + "]");
            }
        }
    }

    private static void printLastOrFirst(int[] n, String one, int pcs, String tokenEvenOdd) {
        int[] current = new int[0];
        if (tokenEvenOdd.equals("even")) {
            current = evenInArray(n);
        } else if (tokenEvenOdd.equals("odd")) {
            current = oddInArray(n);
        }
        if (pcs > current.length) {
            pcs = current.length;
        }
        System.out.print("[");
        if (current.length > 0) {
            if (one.equals("last")) {
                for (int i = current.length - pcs; i < current.length; i++) {
                    System.out.print(current[i]);
                    if (i + 1 < current.length) {
                        System.out.print(", ");
                    }
                }
            } else if (one.equals("first")) {
                for (int i = 0; i < pcs; i++) {
                    System.out.print(current[i]);
                    if (i + 1 < pcs) {
                        System.out.print(", ");
                    }
                }
            }
        }
        System.out.println("]");
    }

    private static void printMax(int[] n, String tokenEvenOdd) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        if (tokenEvenOdd.equals("odd")) {
            for (int i = 0; i < n.length; i++) {
                if (n[i] % 2 == 1) {
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
                if (n[i] % 2 == 1) {
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
            if (n[i] % 2 == 1) {
                countOdd++;
            }
        }
        int[] odd = new int[countOdd];
        int positionOdd = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] % 2 == 1) {
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
