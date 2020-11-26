import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(", ");
        List<String> lessons = new ArrayList<>();
        lessons = getList(data);
        String command = scanner.nextLine();
        while (!"course start".equals(command)) {
            String[] token = command.split(":");
            int index = 0;
            switch (token[0]) {
                case "Add":
                    if (!checkExist(token[1], lessons)) {
                        lessons.add(token[1]);
                    }
                    break;
                case "Insert":
                    index = Integer.parseInt(token[2]);
                    if ((index >= 0 && index < lessons.size()) && (!checkExist(token[1], lessons))) {
                        lessons.add(index, token[1]);
                    }
                    break;
                case "Remove":
                    lessons.remove(token[1]);
                    String ex = token[1] + "-Exercise";
                    lessons.remove(ex);
                    break;
                case "Swap":
                    String exercizeOne = token[1] + "-Exercise";
                    String exercizeTwo = token[2] + "-Exercise";
                    index = lessons.indexOf(token[2]);

                    if (checkExist(token[1], lessons) && checkExist(token[2], lessons)) {
                        lessons.set(lessons.indexOf(token[1]), token[2]);
                        lessons.set(index, token[1]);
                        if (checkExist(exercizeOne, lessons)) {
                            lessons.remove(lessons.indexOf(exercizeOne));
                            lessons.add(lessons.indexOf(token[1]) + 1, exercizeOne);
                        }
                        if (checkExist(exercizeTwo, lessons)) {
                            lessons.remove(lessons.indexOf(exercizeTwo));
                            lessons.add(lessons.indexOf(token[2]) + 1, exercizeTwo);
                        }
                    }
                    break;
                case "Exercise":
                    String addExercize = token[1] + "-Exercise";
                    if (checkExist(token[1], lessons)) {
                        String exercize = token[1] + "-Exercise";
                        if (!checkExist(exercize, lessons)) {
                            lessons.add(lessons.indexOf(token[1]) + 1, addExercize);
                        }
                    } else {
                        lessons.add(token[1]);
                        lessons.add(addExercize);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        printLessons(lessons);
    }

    private static void printLessons(List<String> lessons) {
        for (int i = 0; i < lessons.size(); i++) {
            System.out.println((i + 1) + "." + lessons.get(i));
        }
    }

    private static boolean checkExist(String s, List<String> lessons) {
        boolean exist = false;
        for (String lesson : lessons) {
            if (s.equals(lesson)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    private static List<String> getList(String[] data) {
        List<String> list = new ArrayList<>();
        for (String datum : data) {
            list.add(datum);
        }
        return list;
    }
}
