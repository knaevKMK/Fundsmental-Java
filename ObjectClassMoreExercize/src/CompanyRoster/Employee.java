package CompanyRoster;

public class Employee {

    private String name;
    private double salary;
    private String departament;
    private String mail;
    private int age;

    public Employee(String name, double salary, String departament, String mail, int age) {
        this.name = name;
        this.salary = salary;
        this.departament = departament;
        this.mail = mail;
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartament() {
        return departament;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.mail, this.age);
    }
}
