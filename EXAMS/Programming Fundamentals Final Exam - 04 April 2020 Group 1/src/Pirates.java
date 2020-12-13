import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pirates {
    public static class City {
        private final String name;
        private int population;
        private int gold;

        public City(String name, int population, int gold) {
            this.name = name;
            this.population = population;
            this.gold = gold;
        }

        public String getName() {
            return name;
        }

        public int getPopulation() {
            return population;
        }

        public int getGold() {
            return gold;
        }

        public void setPopulation(int population) {

            this.population = population;
        }

        public void setGold(int gold) {

            this.gold = gold;
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static List<City> cities = new ArrayList<>();

    public static void main(String[] args) {
        String read;
        addCities();
        while (!"End".equals(read = scanner.nextLine())) {
            String[] data = read.split("=>");
            switch (data[0]) {
                case "Plunder":
                    String nameCity = data[1];
                    int population = Integer.parseInt(data[2].trim());
                    int gold = Integer.parseInt(data[3].trim());
                    City city = cityExist(nameCity);
                    if (city != null) {
                        city.setPopulation(city.getPopulation() - population);
                        city.setGold(city.getGold() - gold);
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city.getName(), gold, population);
                        if (city.getPopulation() <= 0 || city.getGold() <= 0) {
                            cities.remove(city);
                            System.out.println(city.getName() + " has been wiped off the map!");
                            continue;
                        }
                    }
                    break;
                case "Prosper":
                    nameCity = data[1];
                    gold = Integer.parseInt(data[2]);
                    city = cityExist(nameCity);
                    if (city != null) {
                        if (gold < 0) {
                            System.out.println("Gold added cannot be a negative number!");
                        } else {
                            city.setGold(city.getGold() + gold);
                            System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n"
                                    , gold, city.getName(), city.getGold());
                        }
                    }
                    break;
            }
        }
        if (cities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
            return;
        }
        System.out.println("Ahoy, Captain! There are " + cities.size() + " wealthy settlements to go to:");
        //, sorted by their gold in descending order, then by their name in ascending order, in the following format:
        cities.stream().sorted((a, b) -> {
            int result = Integer.compare(b.getGold(), a.getGold());
            if (result == 0) {
                result = a.getName().compareTo(b.getName());
            }
            return result;
        })
                .forEach(city -> System.out.println(city.getName() + " -> Population: " + city.getPopulation() +
                        " citizens, Gold: " + city.getGold() + " kg"));
    }


    private static void addCities() {
        String read;
        while (!"Sail".equals(read = scanner.nextLine())) {
            String[] data = read.split("\\|{2}");
            String nameCity = data[0];
            int population = Integer.parseInt(data[1].trim());
            int gold = Integer.parseInt(data[2].trim());
            City city = cityExist(nameCity);
            if (city == null) {
                cities.add(new City(nameCity, population, gold));
                continue;
            }
            city.setPopulation(city.getPopulation() + population);
            city.setGold(city.getGold() + gold);
        }
    }

    private static City cityExist(String nameCity) {
        for (City city : cities) {
            if (city.getName().equals(nameCity)) {
                return city;
            }
        }
        return null;
    }
}
