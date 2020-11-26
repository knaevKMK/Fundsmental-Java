import com.sun.source.tree.IfTree;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //    String[] read = scanner.nextLine().split("\\");
        String s = scanner.nextLine();    //read[read.length - 1];
        s = s.substring(s.lastIndexOf("\\")+1);

        //   for (String s : read) {
        //       if (s.contains(".")) {
        System.out.println("File name: " + s.substring(0, s.indexOf(".")));
        System.out.println("File extension: " + s.substring(s.indexOf(".") + 1));
        //       }
        //   }
    }
}
