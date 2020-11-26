import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        //  Map<String, List<String>> list = new TreeMap<>();
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String read = scanner.nextLine();
            StringBuilder decrypt = new StringBuilder();
            Pattern count = Pattern.compile("[STARstar]");
            Matcher matchCount = count.matcher(read);
            int coutStar = 0;
            while (matchCount.find()) {
                coutStar++;
            }


            //   long coutStar = Arrays.stream(read.split("")).filter(e -> {
            //       String add = "" + (char) e.charAt(0);
            //       return "STARstar".contains(add);
            //   }).count();
            for (int j = 0; j < read.length(); j++) {
                String add = "" + (char) (read.charAt(j) - coutStar);
                decrypt.append(add);
            }
            Pattern pattern = Pattern.compile("@(?<name>[A-Z][a-z]+)" +
                    "[^@\\-!:>]*?" +
                    ":(?<population>\\d+)" +
                    "[^@\\-!:>]*" +
                    "!(?<attack>[AD]{1})!" +
                    "[^@\\-!:>]*" +
                    "\\->(?<soldier>\\d+)");
            Matcher matcher = pattern.matcher(decrypt);
            if (matcher.find()) {
                String name = matcher.group("name");
                String type = matcher.group("attack"); //getType(matcher.group("attack"));
                if (type.equals("A")) {
                    attacked.add(name);
                } else if (type.equals("D")) {
                    destroyed.add(name);
                }
                //        list.putIfAbsent(type, new ArrayList<>());
                //        list.get(type).add(name);
            }
        }
        System.out.println("Attacked planets: " + attacked.size());
        attacked.stream()
                .sorted(((a1, a2) -> a1.compareTo(a2)))
                .forEach(a -> System.out.println("-> " + a));
        System.out.println("Destroyed planets: " + destroyed.size());
        destroyed.stream()
                .sorted(((a1, a2) -> a1.compareTo(a2)))
                .forEach(a -> System.out.println("-> " + a));
        //  list.entrySet()
        ////          .forEach(type -> {
        ////              System.out.println(type.getKey() + " planets: " + type.getValue().size());
        ////              type.getValue().forEach(a -> System.out.println("-> " + a));
        //        });
    }

    // private static String getType(String attack) {
    //     String get = "";
    //     if (attack.equals("A")) {
    //         get = "Attacked";
    //     } else if (attack.equals("D")) {
    //         get = "Destroyed";
    //     }
    //     return get;
    // }
}
