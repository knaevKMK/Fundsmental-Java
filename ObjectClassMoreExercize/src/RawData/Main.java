package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int car = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < car; i++) {
            String[] read = scanner.nextLine().split("\\s+");
            String model = read[0];
            int power = Integer.parseInt(read[2]);
            double pressTireOne = Double.parseDouble(read[5]);
            double pressTireTwo = Double.parseDouble(read[7]);
            double pressTireThree = Double.parseDouble(read[9]);
            double pressTireFour = Double.parseDouble(read[11]);
            Car curentCar = new Car(model, power, pressTireOne, pressTireTwo, pressTireThree, pressTireFour);
            cars.add(curentCar);

        }
        String check = scanner.nextLine();
        for (Car car1 : cars) {
            switch (check) {
                case "fragile"://whose Cargo Type is “fragile” with a tire whose pressure is  < 1,
                    if (1 > car1.getPressTireOne() || 1 > car1.getPressTireTwo() || 1 > car1.getPressTireThree() || 1 > car1.getPressTireFour()) {
                        System.out.println(car1);
                    }
                    break;
                case "flamable":// if the command is “flamable” print all cars whose Cargo Type is “flamable” and have Engine Power > 250.
                    if (250 < car1.getPower())
                        System.out.println(car1);
                    break;
            }

        }


    }
}
