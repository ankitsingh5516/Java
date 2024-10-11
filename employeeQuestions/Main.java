package CoreJava.employeeQuestions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String ...a){
        List<Employee> employeeList = EmployeeDataGenerator.generateSampleData();
/** Given a list of `Employee` objects, filter and
 * retrieve all male employees in the “Engineering” department using Java 8 Streams.*/

        System.out.println("-----------------1. Filtering Employees-----------------");
        List<Employee> emp1 = employeeList.stream()
                .filter(s->(s.getGender().equals("Male") && s.getDepartment().equals("Engineering")))
                .collect(Collectors.toList());
        System.out.println(emp1);

//        emp1.forEach(e->System.out.println(e.getName()));

/** Transform the names of all employees to uppercase using the map operation in streams.*/

        System.out.println("---------------2. Mapping Names to Uppercase-------------------");
        List<String > emp2 = employeeList.stream()
                .map(emp->emp.getName().toUpperCase())
                .collect(Collectors.toList());

        emp2.forEach(s -> System.out.println(s));


        /**Sort a list of ‘Employee’ objects by their salaries in Ascending order using Java 8 Streams.*/
        System.out.println("---------------- 3. Sorting Employees Ascending Order------------------");
        List<Employee> emp3 = employeeList.stream()
                .sorted(Comparator.comparing(employee -> employee.getSalary()))
                .collect(Collectors.toList());

        emp3.forEach(e->System.out.println(e.getName()+" - "+e.getSalary()));

        /**Sort a list of `Employee` objects by their salaries in descending order using Java 8 Streams.*/
        System.out.println("---------------4. Sorting Employees Descending Order-------------------");
        List<Employee> emp4 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        emp4.forEach(e->System.out.println(e.getName()+" "+e.getSalary()));

        /**Group the employees by their gender and print the result using the groupingBy collector.*/
        System.out.println("----------------5. Group Employees by Gender------------------");
        Map<String,List<Employee>> emp5 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender));
        emp5.forEach((s, employees) -> {
            System.out.println(s);
            employees.forEach(employee -> System.out.println(employee));
        });

        /**Group a list of `Employee` objects by their departments using Java 8 Streams,
         * resulting in a map where keys represent departments and
         * values are lists of employees in that department.*/

        System.out.println("----------------6. Group Employees By Department------------------");
        Map<String,List<Employee>> emp6 = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
        emp6.forEach((depart,emp)->{
            System.out.println(depart);
            emp.forEach(employee -> System.out.println(employee));
        });


        /** Count the number of employees for each gender
         * using the groupingBy and counting collectors.*/
        System.out.println("------------------7. Counting Employees by Gender----------------");

        Map<String,Long> emp7 = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getGender(),Collectors.counting()));

        emp7.forEach((gender,count)->{
            System.out.println(gender + "-  "+count);
        });
        /**Calculate the total salary of all female employees in a list of `Employee` objects
         * using Java 8 Streams.*/
        System.out.println("----------------8. Salary Summation------------------");

        Optional<Double> FSalary = employeeList.stream()
                .filter(e->e.getGender().equals("Female"))
                .map(e->e.getSalary())
                .reduce((c,b)->c+b);

        System.out.println("Female total salary- "+FSalary.get());

        /**Find the female employee with the highest salary in a list of `Employee` objects
         * using Java 8 Streams.*/

        System.out.println("---------------9. Finding Highest Salary-------------------");
        Employee empHS = employeeList.stream().filter(e->e.getGender().equals("Female"))
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .findFirst().get();

        System.out.println(empHS);
        System.out.println("---------------10. Extracting Names-------------------");
        List<String> empName = employeeList.stream()
                .map(e->e.getName())
                .collect(Collectors.toList());
        for (String s : empName) {
            System.out.println(s);

        }

        /** Create a list of employees’ names who have a salary greater than 20,000 and
         * are in the “Sales” department using Java 8 Streams.*/
        System.out.println("----------------11. Conditional Mapping------------------");

        List<String> empHSalary = employeeList.stream()
                .filter(employee -> employee.getSalary() > 20000)
                .filter(employee -> "Sales".equals(employee.getDepartment()))
                .map(employee -> employee.getName())
                .collect(Collectors.toList());

        System.out.println("Employees in Sales with Salary > 20,000: " + empHSalary);

        /** Calculate the average salary for all employees and print it.*/
        System.out.println("---------------12. Calculating Average Salary-------------------");
        Double avgSalary = employeeList.stream()
                .mapToDouble(e->e.getSalary())
                        .average()
                                .getAsDouble();
        System.out.println("Average Salary of Employee : "+ avgSalary);

        /**Calculate the average salary for employees in each depart
         * ment using Java 8 Streams.*/
        System.out.println("---------------13. Department Averaging-------------------");
        Map<String,Double> avgDeptSalary = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("Department wise average salary:");
        avgDeptSalary.forEach((k,v)->System.out.println(k+"- "+v));

        /**Increase the salary of all female employees
         * in the “Engineering” department by 10% using Java 8 Streams.*/
        System.out.println("---------------14. Salary Adjustment-------------------");
        List<Double> empSalary = employeeList.stream()
                .filter(s->(s.getGender().equals("Female") && s.getDepartment().equals("Engineering")))
                .map(s->s.getSalary()+(s.getSalary()*10)/100)
                .collect(Collectors.toList());
        System.out.println(empSalary);


        /**Filter and retrieve all employees who are older than 30 years and
         * have a salary greater than 30,000 using Java 8 Streams.*/
        System.out.println("-----------------15. Senior Employees-----------------");
        List<Employee> emp15 = employeeList.stream()
                .filter(s->(s.getAge()>30 && s.getSalary()>30000))
                .collect(Collectors.toList());

        emp15.forEach(e->System.out.println(e));

        /**Find the employee with the highest salary in each department using Java 8 Streams.*/
        System.out.println("-----------------16. Departmental Leaders-----------------");
        Map<String, Employee> highSalaryByDept = employeeList.stream()
                .collect(Collectors.toMap(employee -> employee.getDepartment(),
                        e -> e,
                        (e1, e2) -> e1.getSalary() >= e2.getSalary() ? e1 : e2
                ));

        highSalaryByDept.forEach((department, employee) ->
                System.out.println(department + "- " + employee.getName()));

        /**Calculate the total salary, average salary, and
         * number of female employees in each department using Java 8 Streams.*/
        System.out.println("-------------------17. Department Statistics---------------");
        Map<String, DoubleSummaryStatistics> deptSummarize = employeeList.stream()
                .collect(Collectors.groupingBy(emp->emp.getDepartment(),
                        Collectors.summarizingDouble(emp->emp.getSalary())));

        Map<String, Long> FCountDept = employeeList.stream()
                .filter(employee -> "Female".equals(employee.getGender()))
                .collect(Collectors.groupingBy(emp->emp.getDepartment(), Collectors.counting()));

        deptSummarize.forEach((department, status) -> {
            System.out.println("Department: " + department);
            System.out.println("\tTotal Salary: " + status.getSum());
            System.out.println("\tAverage Salary: " + status.getAverage());
            System.out.println("\tNumber of Female Employees: " + FCountDept.get(department));
        });
        /**Group employees into different salary ranges
         * (e.g., 0-10k, 10k-20k, 20k-30k, 30k-50k) using Java 8 Streams.*/

        System.out.println("--------------------18. Employee by Salary Range---------------------");

        Map<String, List<Employee>> salaryRangeGroups = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> getSalaryRange(employee.getSalary())));

        salaryRangeGroups.forEach((range, employeeList1) -> {
            System.out.println("Salary Range: " + range);
            employeeList1.forEach(employee -> System.out.println("   " + employee.getName()+"- "+employee.getSalary()));

        });

        /**Concatenate the names of all employees in the list into
         * a single comma-separated string using Java 8 Streams.*/
        System.out.println("------------------19. Name Concatenation------------------");
        String concatName = employeeList.stream()
                .map(emp->emp.getName())
                .collect(Collectors.joining(", "));

        System.out.println("Concatenate Name- " + concatName);

        System.out.println("------------------20. Printing Employment Duration------------------");
        /**Determine and print the number of years each employee has been with the company using the ChronoUnit class.*/
        LocalDate currentDate = LocalDate.now();

        for (Employee employee : employeeList) {
            int yearsWithCompany = (int) ChronoUnit.YEARS.between(employee.getDateOfJoining(), currentDate);
            System.out.println(employee.getName() + " - " + yearsWithCompany + " years with company");
        }

/**Filter and print the employees who joined the company after a specific date.*/
      System.out.println("------------------21. Filtering Employees by Date of Joining------------------");


        LocalDate specificDate = LocalDate.parse("10-11-2015", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        List<Employee> filteredEmployees = employeeList.stream()
                .filter(emp -> emp.getDateOfJoining().isAfter(specificDate))
                .collect(Collectors.toList());
        System.out.println("Employee Joining details-");
        filteredEmployees.forEach(emp ->
                System.out.println("\tName- "+emp.getName()+", Joining date- "+ emp.getDateOfJoining()));
    }


    private static String getSalaryRange(double salary) {
        if (salary < 10000) {
            return "0-10k";
        } else if (salary < 20000) {
            return "10k-20k";
        } else if (salary < 30000) {
            return "20k-30k";
        } else if (salary < 50000) {
            return "30k-50k";
        } else {
            return "50k+";
        }
    }
}