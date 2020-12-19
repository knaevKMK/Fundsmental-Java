import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NeedForSpeedIII {
    private static Scanner scanner = new Scanner(System.in);

    private static class Car {
        private String model;
        private int mileage;
        private int fuel;

        public Car(String model, int distance, int fuel) {
            this.model = model;
            this.mileage = distance;
            this.fuel = fuel;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }

        public String getModel() {
            return model;
        }

        public int getMileage() {
            return mileage;
        }

        public int getFuel() {
            return fuel;
        }
    }

    private static List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        createCar();
        driveCar();
        getCars();
    }

    private static void getCars() {
        cars.stream().sorted(Comparator.comparing(Car::getMileage).reversed().thenComparing(Car::getModel))
                .forEach(car -> printResul(String.format("%s -> Mileage: %d kms, Fuel in the tank: %d lt.", car.getModel(), car.getMileage(), car.getFuel())));
    }

    private static void driveCar() {
        String read;
        while (!"Stop".equals(read = scanner.nextLine())) {
            String[] data = read.split(" : ");

            String model = data[1];
            int value = Integer.parseInt(data[2]);

            switch (data[0]) {
                case "Drive":
                    int fuel = Integer.parseInt(data[3]);
                    driveDsitance(model, value, fuel);
                    break;
                case "Refuel":
                    reFuel(model, value);
                    break;
                case "Revert":
                    revert(model, value);
                    break;
            }
        }
    }

    private static void revert(String model, int km) {
        Car car = getCat(model);
        if (car == null) {
            return;
        }
        if (car.getMileage() - km <= 10000) {
            car.setMileage(10000);
            return;
        }
        car.setMileage(car.getMileage() - km);
        printResul(model + " mileage decreased by " + km + " kilometers");
    }

    private static void reFuel(String model, int fuel) {
        Car car = getCat(model);
        if (car == null) {
            return;
        }
        if (fuel + car.getFuel() > 75) {
            fuel = 75 - car.getFuel();
        }
        car.setFuel(car.getFuel() + fuel);
        printResul(model + " refueled with " + fuel + " liters");
    }

    private static void driveDsitance(String model, int distance, int fuel) {
        Car car = getCat(model);
        if (car != null) {
            if (car.getFuel() < fuel) {
                printResul("Not enough fuel to make that ride");
            } else {
                car.setMileage(car.getMileage() + distance);
                car.setFuel(car.getFuel() - fuel);
                printResul(String.format("%s driven for %d kilometers. %d liters of fuel consumed.", model, distance, fuel));
                if (car.getMileage() > 100000) {
                    printResul("Time to sell the " + model + "!");
                    cars.remove(car);
                }
            }

        }
    }

    private static void printResul(String s) {
        System.out.println(s);
    }

    private static Car getCat(String model) {
        for (Car car : cars) {
            if (car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    private static void createCar() {
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\|");
            String model = data[0];
            int mileage = Integer.parseInt(data[1]);
            int fuel = Integer.parseInt(data[2]);
            cars.add(new Car(model, mileage, fuel));
        }
    }
}
