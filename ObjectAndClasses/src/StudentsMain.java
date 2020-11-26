import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String read = scanner.nextLine();
        List<Student> students = new ArrayList<>();

        while (!"end".equals(read)) {
            String[] token = read.split(" ");
            String firstName = token[0];
            String lastName = token[1];
            int age = Integer.parseInt(token[2]);
            String town = token[3];

            if (theStudenttExist(students, firstName, lastName)) {
                Student theStudent = getStudent(students, firstName, lastName);

                theStudent.setFirstName(firstName);
                theStudent.setLastName(lastName);
                theStudent.setAge(age);
                theStudent.setTown(town);

            } else {
                Student theStudent = new Student(firstName, lastName, age, town);
                students.add(theStudent);
            }
            read = scanner.nextLine();
        }

        String findList = scanner.nextLine();

        for (Student student : students) {
            if (findList.equals(student.getTown())) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }

    private static Student getStudent(List<Student> students, String firstName, String lastName) {
        Student existStudent = null;
        for (Student student : students) {
            if (theStudenttExist(students, firstName, lastName)) {
                existStudent = student;
            }
        }
        return existStudent;
    }

    private static boolean theStudenttExist(List<Student> students, String firstName, String lastName) {
        boolean isExist = false;
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                isExist = true;
            }
        }
        return isExist;
    }
}
