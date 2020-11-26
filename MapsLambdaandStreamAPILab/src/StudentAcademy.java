import java.util.*;
import java.util.zip.DeflaterOutputStream;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, ArrayList<Double>> student = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            student.putIfAbsent(name, new ArrayList<>());
            student.get(name).add(grade);
        }
        Map<String, Double> gradeList = new LinkedHashMap<>();
        for (Map.Entry<String, ArrayList<Double>> entry : student.entrySet()) {
            double average = 0;
            for (Double aDouble : entry.getValue()) {
                average += aDouble;
            }

            average /= entry.getValue().size();
            if (average >= 4.5) {
                gradeList.putIfAbsent(entry.getKey(), 0.0);
                gradeList.put(entry.getKey(), average);
            }
        }
        gradeList
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(a -> System.out.println(String.format("%s -> %.2f", a.getKey(), a.getValue())));
    }
}
