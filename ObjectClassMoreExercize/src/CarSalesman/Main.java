package CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        int nEngines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < nEngines; i++) {
            String[] readEngines = scanner.nextLine().split("\\s+");
            int power = Integer.parseInt(readEngines[1]);
            String displacement = "n/a"; // (readEngines[2]);
            String efficiency = "n/a";
            if (readEngines.length > 2) {
                if (readEngines[2].charAt(0) > '0' && readEngines[2].charAt(0) <= '9') {
                    displacement = readEngines[2];

                    if (readEngines.length > 3) {
                        efficiency = readEngines[3];
                    }
                } else {
                    efficiency = readEngines[2];
                }
            }

            Engine engine = new Engine(readEngines[0], power, displacement, efficiency);
            engines.add(engine);
        }

        int nCasr = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < nCasr; i++) {
            String[] readCars = scanner.nextLine().split("\\s+");
            String model = readCars[0];
            String engin = readCars[1];
            String weight = "n/a"; //readCars[2];
            String color = "n/a"; // readCars[3];
            if (readCars.length > 2) {
                if (readCars[2].charAt(0) >= '0' &&
                        readCars[2].charAt(0) <= '9') {
                    weight = readCars[2];
                    if (readCars.length > 3) {
                        color = readCars[3];
                    }
                } else {
                    color = readCars[2];
                }
            }
            int power = 0;
            String displacement = "n/a";
            String efficiency = "n/a";
            for (Engine engine : engines) {
                if (readCars[1].equals(engine.getEngin())) {
                    power = engine.getPower();
                    displacement = engine.getDisplacement();
                    efficiency = engine.getEfficiency();
                }
            }
            Car car = new Car(model, engin, weight, color, power, displacement, efficiency);
            cars.add(car);
        }
        for (Car car : cars) {
            System.out.println(car);
        }
        ;
    }
}
