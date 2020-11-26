import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokemonDoNotGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");
        List<Integer> list = new ArrayList<>();
        list = getList(data);
        int sumRemoved = 0;

        while (!list.isEmpty()) { //The increasing and decreasing of elements should be done in these cases, also.
            // The element, whose value you should use, is the REMOVED element
            int index = Integer.parseInt(scanner.nextLine());
            int removedElement = 0;
            if (index < 0) { //remove the first element of the sequence, and COPY the last element to its place.
                removedElement = list.get(0);
                list.set(0, list.get(list.size() - 1));
            } else if (index > list.size() - 1) { //given index is GREATER than the last index of the sequence,
                // remove the last element from the sequence, and COPY the first element to its place.
                removedElement = list.get(list.size() - 1);
                list.set(list.size() - 1, list.get(0));
            } else {
                removedElement = list.remove(index);
            }
            sumRemoved += removedElement;
            list = setIncereseOrDecrace(removedElement, list);
        }
        System.out.println(sumRemoved);
    }

    private static List<Integer> setIncereseOrDecrace(int removedElement, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= removedElement) {
                list.set(i, list.get(i) + removedElement);
            } else {
                list.set(i, list.get(i) - removedElement);
            }
        }
        return list;
    }

    private static List<Integer> getList(String[] data) {
        List<Integer> list = new ArrayList<>();
        for (String datum : data) {
            list.add(Integer.parseInt(datum));
        }
        return list;
    }
}
