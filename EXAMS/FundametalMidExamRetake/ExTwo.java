import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());

        int[] wagons = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        for (int i = 0; i < wagons.length; i++) {
            if (wagons[i] >= 0 && wagons[i] < 4) {
                if (4 - wagons[i] > 0) {
                    int freeSeats = 4 - wagons[i];
                    if (people >= freeSeats) {
                        people -= freeSeats;
                        wagons[i] = 4;
                    } else {
                        freeSeats -= people;
                        people = 0;
                        wagons[i] = 4 - freeSeats;
                    }
                }
            }
            if (people == 0) {
                break;
            }
        }


        boolean hasFreeSeat = false;
        for (Integer wagon : wagons) {
            if (wagon < 4) {
                hasFreeSeat = true;
                break;
            }
        }

        if (hasFreeSeat) {
            System.out.println("The lift has empty spots!");
            printList(wagons);
        } else {
            if (people == 0) {
                printList(wagons);
            } else {
                System.out.printf("There isn't enough space! %d people in a queue!%n", people);
                printList(wagons);
            }
        }
    }


    private static void printList(int[] wagons) {
        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
