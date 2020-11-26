import com.sun.source.tree.IfTree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");
        List<String> line = new ArrayList<>();
        line = getList(data);

        String command = scanner.nextLine();
        while (!"3:1".equals(command)) {
            String[] token = command.split("\\s+");
            String makeIt = token[0];
            switch (makeIt) {
                case "merge":
                    int starIndex = Math.max(Integer.parseInt(token[1]), 0);
                    if (starIndex > line.size() - 1) {
                        command = scanner.nextLine();
                        continue;
                    }
                    int endIndex = Math.min(Integer.parseInt(token[2]), line.size() - 1);
                    if (endIndex == 0 || endIndex <= starIndex) {
                        command = scanner.nextLine();
                        continue;
                    }
                    line = mergeList(line, starIndex, endIndex);
                    break;
                case "divide":
                    int index = (Integer.parseInt(token[1]));
                    int partition = Integer.parseInt(token[2]);
                    if (partition > 0 && index >= 0 && index < line.size()) {
                        line = divideList(line, index, partition);
                    }
                    break;

            }
            command = scanner.nextLine();
        }
        System.out.println(line.toString().replaceAll("[\\[\\],]", ""));
    }

    private static List<String> mergeList(List<String> line, int starIndex, int endIndex) {
        String[] merge = new String[endIndex - starIndex + 1];
        int count = 0;
        for (int i = endIndex; i >= starIndex; i--) {
            merge[count] = line.remove(i);
            count++;
        }
        String curent = "";
        for (int i = merge.length - 1; i >= 0; i--) {
            curent += merge[i];
        }
        line.add(starIndex, curent);
        return line;
    }

    private static List<String> divideList(List<String> line, int index, int partition) {


        String[] curent = line.get(index).split("");
        List<String> ofCurent = new ArrayList<>();
        line.remove(index);

        if (partition > curent.length) {
            partition = curent.length;
        }

        int pcs = (curent.length / partition);
        int different = (curent.length % partition);

        for (int j = 0; j < partition - 1; j++) {
            String curentPartition = "";
            for (int i = 0; i < pcs; i++) {
                curentPartition += curent[(j * pcs) + i];
            }
            ofCurent.add(curentPartition);
        }
        String curenetPartition = "";
        for (int i = pcs * (partition - 1); i < curent.length; i++) {
            curenetPartition += curent[i];
        }

        ofCurent.add(curenetPartition);
        line = addList(line, ofCurent, index);

        return line;
    }

    private static List<String> addList(List<String> line, List<String> ofCurent, int index) {
        for (int i = ofCurent.size() - 1; i >= 0; i--) {
            line.add(index, ofCurent.get(i));
        }
        return line;
    }

    private static List<String> getList(String[] data) {
        List<String> creat = new ArrayList<>();
        for (String datum : data) {
            creat.add(datum);
        }
        return creat;
    }
}
