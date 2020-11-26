import java.util.*;

public class MixedupLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> lineOne = new ArrayList();
        lineOne = getList(scanner.nextLine());
        List<Integer> lineTwo = new ArrayList();
        lineTwo = getList(scanner.nextLine());
        int[] range = getRange(lineOne, lineTwo);


        System.out.println(Shafule(lineOne, lineTwo, range));

    }

    private static int[] getRange(List<Integer> lineOne, List<Integer> lineTwo) {

        List<Integer> lineLong = lineOne;
        int index = lineOne.size() - 1;
        if (lineLong.size() < lineTwo.size()) {
            lineLong = lineTwo;
            index = 1;
        }

        int[] set = new int[2];
        for (int i = 0; i < 2; i++) {
            set[i] = lineLong.get(index - i);
            lineLong.remove(index - i);
        }
        return set;
    }

    private static String Shafule(List<Integer> lineOne, List<Integer> lineTwo, int[] n) {
        List<Integer> shufle = new ArrayList();
        int longestLine = lineOne.size();
        if (longestLine > lineTwo.size()) {
            longestLine = lineTwo.size();
        }
        for (int i = 0; i < longestLine; i++) {
            if (lineOne.get(i) != null) {
                shufle.add(lineOne.get(i));
            }
            if (lineTwo.get(lineTwo.size() - i - 1) != null) {
                shufle.add(lineTwo.get(lineTwo.size() - i - 1));
            }
        }
        int upRange = n[0];
        int downRange = n[1];
        if (n[0] < n[1]) {
            upRange = n[1];
            downRange = n[0];
        }
        for (int i = 0; i < shufle.size(); i++) {
            if (shufle.get(i) >= upRange || shufle.get(i) <= downRange) {
                shufle.remove(i);
                i--;
            }
        }
        Collections.sort(shufle);
        return shufle.toString().replaceAll("[\\[\\],]", "");
    }

    private static List<Integer> getList(String nextLine) {
        String[] line = nextLine.split("\\s+");
        List<Integer> list = new ArrayList();
        for (String current : line) {
            list.add(Integer.parseInt(current));
        }
        return list;
    }
}
