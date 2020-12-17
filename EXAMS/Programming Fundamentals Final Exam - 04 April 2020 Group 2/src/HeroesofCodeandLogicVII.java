import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesofCodeandLogicVII {
    private static Scanner scanner = new Scanner(System.in);

    public static class Hero {
        private String name;
        private int hitPoint;
        private int manaPoint;

        public Hero(String name, int hitPoint, int manaPoint) {
            this.name = name;
            this.hitPoint = hitPoint;
            this.manaPoint = manaPoint;
        }

        public void setHitPoint(int hitPoint) {
            if (hitPoint < 0) {
                hitPoint = 0;
            }
            if (hitPoint > 100) {
                hitPoint = 100;
            }
            this.hitPoint = hitPoint;
        }

        public void setManaPoint(int manaPoint) {
            if (manaPoint < 0) {
                manaPoint = 0;
            }
            if (manaPoint > 200) {
                manaPoint = 200;
            }
            this.manaPoint = manaPoint;
        }

        public String getName() {
            return name;
        }

        public int getHitPoint() {
            return hitPoint;
        }

        public int getManaPoint() {
            return manaPoint;
        }
    }


    public static void main(String[] args) {
        Map<String, Hero> list = new HashMap<>();
        addHeroes(list);
        play(list);
        printList(list);

    }

    private static void printList(Map<String, Hero> list) {
        list.values().stream().sorted((a, b) ->
        {
            int reslut = Integer.compare(b.getHitPoint(), a.getHitPoint());
            if (reslut == 0) {
                reslut = a.getName().compareTo(b.getName());
            }
            return reslut;
        }).forEach(value -> {
            System.out.println(value.getName());
            System.out.println("  HP: " + value.getHitPoint());
            System.out.println("  MP: " + value.getManaPoint());
        });
    }

    private static void play(Map<String, Hero> list) {
        String read;
        while (!"End".equals(read = scanner.nextLine())) {
            String[] data = read.split(" - ");

            String command = data[0];
            String nameHerro = data[1];

            int value = Integer.parseInt(data[2]);
            Hero herro = list.get(nameHerro);
            switch (command) {
                case "CastSpell":
                    String recived = (data[3]);

                    if (value > list.get(nameHerro).getManaPoint() || herro == null) {
                        printResult(String.format("%s does not have enough MP to cast %s!", nameHerro, recived));

                    } else {

                        herro.setManaPoint(herro.getManaPoint() - value);

                        printResult(String.format("%s has successfully cast %s and now has %d MP!"
                                , nameHerro, data[3], herro.getManaPoint()));
                    }
                    break;
                case "TakeDamage":

                    String attaker = (data[3]);

                    herro.setHitPoint(herro.getHitPoint() - value);

                    if (herro.getHitPoint() > 0) {
                        printResult(String.format("%s was hit for %d HP by %s and now has %d HP left!"
                                , nameHerro, value, attaker, herro.getHitPoint()));
                    } else {

                        list.remove(nameHerro);
                        printResult(String.format("%s has been killed by %s!", nameHerro, attaker));
                    }
                    break;
                case "Recharge":
                    if (value + herro.getManaPoint() > 200) {
                        value = 200 - herro.getManaPoint();
                    }
                    herro.setManaPoint(herro.getManaPoint() + value);
                    printResult(String.format("%s recharged for %d MP!", nameHerro, value));
                    break;
                case "Heal":
                    if (value + herro.getHitPoint() > 100) {
                        value = 100 - herro.getHitPoint();
                    }
                    int helt = Integer.parseInt(data[2]);
                    herro.setHitPoint(herro.getHitPoint() + helt);
                    printResult(String.format("%s healed for %d HP!", nameHerro, value));
                    break;
            }
        }
    }

    private static void printResult(String string) {
        System.out.println(string);
    }

    private static void addHeroes(Map<String, Hero> list) {
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int hP = Integer.parseInt(data[1]);
            int mP = Integer.parseInt(data[2]);

            list.put(name, new Hero(name, hP, mP));
        }
    }
}
