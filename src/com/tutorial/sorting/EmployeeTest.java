package com.tutorial.sorting;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeTest {

     List<Employee> employees = new ArrayList<>();

     Comparator<Employee> byHireDate = new Comparator<Employee>() {
        public int compare(Employee left, Employee right) {
            if (left.getHireDate().isBefore(right.getHireDate())) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    public  void populate() {
        employees.add(new Employee(123, "Jack", "Johnson", LocalDate.of(1988, Month.APRIL, 12)));
        employees.add(new Employee(345, "Cindy", "Bower", LocalDate.of(2011, Month.DECEMBER, 15)));
        employees.add(new Employee(567, "Pam", "Node", LocalDate.of(2005, Month.JUNE, 07)));
        employees.add(new Employee(467, "Pam", "Krauss", LocalDate.of(2005, Month.JUNE, 07)));
        employees.add(new Employee(435, "Fred", "Shak", LocalDate.of(1988, Month.APRIL, 17)));
        employees.add(new Employee(678, "Ann", "Lee", LocalDate.of(2007, Month.APRIL, 12)));
    }

    public void sortByDateWithComparator(){
        Collections.sort(employees, byHireDate);
        employees.stream().forEach(e -> System.out.println(e));

    }

    public void sortByEmpNumberJava8() {

        Comparator<Employee> byEmployeeNumber = (e1, e2) -> Integer.compare(
                e1.getEmployeeNumber(), e2.getEmployeeNumber());

        employees
                .stream()
                .sorted(byEmployeeNumber)
                .forEach(e -> System.out.println(e));
    }

    public void filter_get_first() {

        java.util.Optional<Employee> employee = employees
                .stream()
                .sorted((e1, e2) -> e1.getHireDate()
                        .compareTo(e2.getHireDate()))
                .findFirst();

        System.out.println(employee.get());
    }

    public void multiple_sort() {

        Comparator<Employee> byFirstName = (e1, e2) -> e1
                .getEmployeeFirstName().compareTo(e2.getEmployeeFirstName());

        Comparator<Employee> byLastName = (e1, e2) -> e1.getEmployeeLastName()
                .compareTo(e2.getEmployeeLastName());

        employees.stream().sorted(byFirstName.thenComparing(byLastName))
                .forEach(e -> System.out.println(e));
    }

    public static void main(String[] args) {
        EmployeeTest et = new EmployeeTest();
        et.populate();
        et.sortByDateWithComparator();
        System.out.println();
        et.sortByEmpNumberJava8();
        System.out.println();
        et.filter_get_first();
        System.out.println();
        et.multiple_sort();
    }
}
