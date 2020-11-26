package CompanyRoster;

import com.sun.source.tree.IfTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> person = new ArrayList<>();


        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] read = scanner.nextLine().split("\\s+");
            String name = read[0];
            double salary = Double.parseDouble(read[1]);
            String departament = read[3];
            String mail = "n/a";
            int age = -1;
            if (read.length > 4) {
                mail = read[4];
                if (read[read.length - 1].charAt(0) > '0' &&
                        read[read.length - 1].charAt(0) <= '9') {
                    age = Integer.parseInt(read[read.length - 1]);
                    if ((read.length) == 5) {
                        mail = "n/a";
                    }
                }
            }
            Employee people = new Employee(name, salary, departament, mail, age);
            person.add(people);
        }

        List<Salary> salarySums = new ArrayList<>();
        int counerCreat = 0;
        for (Employee employee : person) {
            int count = 1;
            double sumSalary = employee.getSalary();
            String currentDepartment = employee.getDepartament();
            Salary salary = new Salary(currentDepartment, sumSalary, count);
            if (counerCreat == 0) {
                counerCreat++;
                salarySums.add(salary);
            }
            for (Salary salarySum : salarySums) {
                if (employee.getDepartament().equals(salarySum.getDepartment())) {
                    count = count + salarySum.getCount();
                    salarySum.setCount(count);
                    sumSalary += salarySum.getSalary();
                    salarySum.setSalary(sumSalary);
                    break;
                } else {
                    salarySums.add(salary);
                    break;
                }
            }

        }

        for (Salary salarySum : salarySums) {
            double avgsalary = salarySum.getSalary() / salarySum.getCount();
            salarySum.setSalary(avgsalary);
        }

        String expensiveDepartment = "";
        double maxSalary = 0;
        for (Salary salarySum : salarySums) {
            if (salarySum.getSalary() > maxSalary) {
                maxSalary = salarySum.getSalary();
                expensiveDepartment = salarySum.getDepartment();
            }
        }
        System.out.println("Highest Average Salary: " + expensiveDepartment);

        person.sort(Comparator.comparing(Employee::getSalary).reversed());

        for (Employee employee : person) {
            if (expensiveDepartment.equals(employee.getDepartament()))
                System.out.println(employee.toString());
        }

    }

}
