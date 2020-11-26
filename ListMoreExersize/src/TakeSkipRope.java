import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] read = scanner.nextLine().split("");

        List<String> line = new ArrayList();
        line = getString(read);
        List<Integer> take = new ArrayList<>();
        take = getNums(line);
        List<Integer> skip = new ArrayList<>();
        skip = getunderList(take);

        String print = "";
        int count = 0;
        for (int i = 0; i < take.size(); i++) {
            int countCurent = 0;
            int endIndex = count + (take.get(i) + skip.get(i));
            for (int j = count; j < endIndex; j++) {
                count++;
                countCurent++;
                if (count > line.size()) {
                    break;
                }
                if (countCurent <= take.get(i)) {
                    print += line.get(j);
                }
            }
        }
        System.out.println(print);
    }

    private static List<Integer> getunderList(List<Integer> take) {
        List<Integer> skip = new ArrayList<>();
        for (int i = 0; i < take.size(); i++) {
            skip.add(take.get(i + 1));
            take.remove(i + 1);
        }
        return skip;
    }

    private static List<Integer> getNums(List<String> line) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < line.size(); i++) {
            char curent = line.get(i).charAt(0);
            if (curent >= '0' && curent <= '9') {
                nums.add(Integer.parseInt(String.valueOf(curent)));
                line.remove(i);
                i--;
            }
        }
        return nums;
    }

    private static List<String> getString(String[] read) {
        List<String> list = new ArrayList();
        for (String current : read) {
            list.add(current);
        }
        return list;
    }
}
