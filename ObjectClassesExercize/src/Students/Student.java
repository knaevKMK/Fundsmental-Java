package Students;

public class Student {

    private String name;
    private String family;
    private double grade;

    public Student(String name, String family, double grade) {
        this.name = name;
        this.family = family;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f", name, family, grade);
    }
}
