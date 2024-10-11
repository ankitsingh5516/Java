package CoreJava.employeeQuestions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/** Given a list of `Employee` objects, filter and retrieve all male employees in the “Engineering” department using Java 8 Streams.*/
public class EmployeeDataGenerator {
    public static List<Employee> generateSampleData() {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("John Doe", 6000.0, "IT", 30, "Male", LocalDate.of(2019, 5, 15)));
        employeeList.add(new Employee("Jane Smith", 70000.0, "HR", 28, "Female", LocalDate.of(2020, 8, 22)));
        employeeList.add(new Employee("Robert Johnson", 30000.0, "Finance", 35, "Male", LocalDate.of(2018, 3, 10)));
        employeeList.add(new Employee("Emily Davis", 55000.0, "Marketing", 25, "Female", LocalDate.of(2021, 1, 5)));
        employeeList.add(new Employee("Michael Brown", 35000.0, "Engineering", 32, "Male", LocalDate.of(2017, 11, 18)));
        employeeList.add(new Employee("Alice Miller", 72000.0, "Sales", 29, "Female", LocalDate.of(2019, 9, 8)));
        employeeList.add(new Employee("David Wilson", 68000.0, "IT", 31, "Male", LocalDate.of(2020, 4, 30)));
        employeeList.add(new Employee("Sophia Davis", 85000.0, "Engineering", 28, "Female", LocalDate.of(2018, 7, 12)));
        employeeList.add(new Employee("Henry Johnson", 60000.0, "Engineering", 27, "Male", LocalDate.of(2022, 2, 15)));
        employeeList.add(new Employee("Olivia Brown", 67000.0, "Marketing", 26, "Female", LocalDate.of(2021, 6, 25)));
        employeeList.add(new Employee("Ethan Smith", 78000.0, "Sales", 33, "Male", LocalDate.of(2017, 12, 5)));
        employeeList.add(new Employee("Ava Wilson", 59000.0, "HR", 24, "Female", LocalDate.of(2019, 10, 20)));
        employeeList.add(new Employee("Liam Davis", 71000.0, "Engineering", 30, "Male", LocalDate.of(2018, 1, 8)));
        employeeList.add(new Employee("Mia Johnson", 73000.0, "IT", 34, "Female", LocalDate.of(2020, 3, 22)));
        employeeList.add(new Employee("Noah Miller", 69000.0, "Finance", 32, "Male", LocalDate.of(2017, 8, 14)));

        return employeeList;
    }
}
