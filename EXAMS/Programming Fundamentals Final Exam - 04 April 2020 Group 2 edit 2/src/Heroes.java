import java.util.*;

public class Heroes {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, List<Integer>> heroes = new LinkedHashMap<>();
        addHeroes(heroes);
        play(heroes);
        printHeroes(heroes);
    }

    private static void printHeroes(Map<String, List<Integer>> heroes) {
        heroes.entrySet().stream().sorted((a, b) -> {
            int result = Integer.compare(b.getValue().get(0), a.getValue().get(0));
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(herro -> {
            System.out.println(herro.getKey());
            System.out.println("  HP: " + herro.getValue().get(0));
            System.out.println("  MP: " + herro.getValue().get(1));
        });
    }

    private static void play(Map<String, List<Integer>> heroes) {
        String read;
        while (!"End".equals(read = scanner.nextLine())) {
            String[] data = read.split(" - ");
            String heroName = data[1];
            int value = Integer.parseInt(data[2]);
            String result;
            switch (data[0]) {
                case "CastSpell":
                    String spelledHerro = data[3];
                    result = (castSpell(heroName, value, spelledHerro, heroes));
                    break;
                case "TakeDamage":
                    String attacker = data[3];
                    result = takeDamege(heroName, value, attacker, heroes);
                    break;
                case "Recharge":
                    result = recharge(heroName, value, heroes);
                    break;
                case "Heal":
                    result = heal(heroName, value, heroes);
                    break;
                default:
                    result = null;
            }
            System.out.println(result);
        }
    }

    private static String heal(String heroName, int value, Map<String, List<Integer>> heroes) {
        int points = heroes.get(heroName).get(0);
        if (points + value > 100) {
            value = 100 - points;
        }
        heroes.get(heroName).set(0, points + value);
        return String.format("%s healed for %d HP!", heroName, value);

    }

    private static String recharge(String heroName, int value, Map<String, List<Integer>> heroes) {
        int points = heroes.get(heroName).get(1);
        if (points + value > 200) {
            value = 200 - points;
        }
        heroes.get(heroName).set(1, points + value);
        return String.format("%s recharged for %d MP!", heroName, value);
    }

    private static String takeDamege(String heroName, int value, String attacker, Map<String, List<Integer>> heroes) {
        int points = heroes.get(heroName).get(0);
        if (value > points) {
            value = points;
        }
        heroes.get(heroName).set(0, points - value);

        if (heroes.get(heroName).get(0) > 0) {
            return String.format("%s was hit for %d HP by %s and now has %s HP left!"
                    , heroName, value, attacker, heroes.get(heroName).get(0));
        } else {
            heroes.remove(heroName);
            return heroName + " has been killed by " + attacker + "!";
        }
    }

    private static String castSpell(String heroName, int value, String spelledHerro, Map<String, List<Integer>> heroes) {
        if (heroes.containsKey(heroName) && heroes.get(heroName).get(1) >= value) {
            int points = heroes.get(heroName).get(1);
            heroes.get(heroName).set(1, points - value);
            points = heroes.get(heroName).get(1);
            return String.format("%s has successfully cast %s and now has %d MP!", heroName, spelledHerro, points);
        }
        return heroName + " does not have enough MP to cast " + spelledHerro + "!";
    }

    private static void addHeroes(Map<String, List<Integer>> list) {
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int hitPoint = Integer.parseInt(data[1]);
            if (hitPoint > 100) {
                hitPoint = 100;
            }
            int manaPoint = Integer.parseInt(data[2]);
            if (manaPoint > 200) {
                manaPoint = 200;
            }
            list.put(name, new ArrayList<>());
            list.get(name).add(hitPoint);
            list.get(name).add(manaPoint);
        }
    }
}
