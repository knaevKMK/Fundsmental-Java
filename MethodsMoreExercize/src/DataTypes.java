import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        String data = scanner.nextLine();

        printResult(type, data);

    }

    private static void printResult(String type, String data) {
        String result = "";
        switch (type) {
            case "int":
                result = getIntResult(data);
                break;
            case "real":
                result = getRealResult(data);
                break;
            case "string":
                result = getStringResult(data);
                break;
        }
        System.out.println(result);
    }

    private static String getStringResult(String data) {
        data = "$" + data + "$";
        return data;
    }

    private static String getRealResult(String data) {
        double realInteger = Double.parseDouble(data);
        realInteger *= 1.5;
        return String.valueOf(String.format("%.2f", realInteger));
    }

    private static String getIntResult(String data) {
        int integer = Integer.parseInt(data);
        integer *= 2;
        return String.valueOf(integer);
    }
}
