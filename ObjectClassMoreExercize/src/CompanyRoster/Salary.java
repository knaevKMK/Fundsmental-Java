package CompanyRoster;

public class Salary {
    private String department;
    private double salary;
    private int count;


    public Salary(String department, double salary, int count) {
        this.department = department;
        this.salary = salary;
this.count=count;
    }

    public String getDepartment() {
        return department;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSalary() {
        return salary;
    }
}
