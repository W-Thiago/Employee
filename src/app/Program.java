package app;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        for (int i=0 ; i<n;i++){
            System.out.printf("Emplyoee #%d:\n" ,i + 1);
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary:");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id,name,salary);

            list.add(emp);
        }


        System.out.print("Enter the employee id that will have salary increase : ");
        int id = sc.nextInt();
        Integer pos = 1;

        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (emp == null) {
            System.out.println("This id does not exist! ");
        }
        else {
            System.out.print("Enter the percentage: ");
            double percentagem = sc.nextDouble();
            list.get(pos).increaseSalary(percentagem);
        }

        System.out.println();
        System.out.println("List of employees: ");
        for (Employee x: list) {
            System.out.println(x);
        }

        sc.close();
    }

}
