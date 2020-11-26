import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //   String line = "1, 21, 213, 4, 15, 6, 77";
        String line = "red 123, red 12, blue 123, green 1, dark 15, blue 16, green 17";

        Stream<String> str = Arrays.stream(line.split(", "));


        // Map<String, List<Integer>> map = new LinkedHashMap<>();
        // map = getMap(line);
        // map.entrySet(). stream()
        //         .filter(stringListEntry -> stringListEntry.getKey().contains("e"))
        //         .forEach(e-> System.out.println(e));
        // System.out.println(map);


        //   List<String> aBv = Arrays.stream(line.split(",\\s+"))
        // .filter(e -> e.contains("1"))
        //.skip(2)
        //     .sorted((e1,e2)-> Integer.compare(Integer.parseInt(e2),Integer.parseInt(e1)))
        //   .sorted((e1, e2) -> {
        //        int result = e1.compareTo(e2);
        //        if (result == 0) {
        //            String[] tokenOne = e1.split("\\s+");
        //            String[] tokenTwo = e2.split("\\s+");
        //            int eIntOne = Integer.parseInt(tokenOne[1]);
        //            int eIntTwo = Integer.parseInt(tokenTwo[1]);
        //            result = Integer.compare(eIntTwo, eIntOne);
        //        }
        //        return result;
        //    })
        //    //  .limit(5)
        //    .collect(Collectors.toList());
        //  System.out.println(aBv);

        //   List<Integer> num = Arrays.stream(line.split("\\s+"))
        //           .mapToInt(e -> Integer.parseInt(e))
        //           .collect()

    }

    private static Map<String, List<Integer>> getMap(String line) {
        Map<String, List<Integer>> map = new TreeMap<>();
        String[] token = line.split(",\\s+");
        for (String s : token) {
            String[] subToken = s.split("\\s+");
            map.putIfAbsent(subToken[0], new ArrayList<Integer>());
            map.get(subToken[0]).add(Integer.parseInt(subToken[1]));
        }
        return map;
    }
}
