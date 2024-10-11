package CoreJava.employeeQuestions;

import java.time.LocalDate;

class Employee {
    private String name;
    private double salary;
    private String department;
    private int age;
    private String gender;
    private LocalDate dateOfJoining;

    public Employee() {

    }

    public Employee(String name, double salary, String department, int age, String gender, LocalDate dateOfJoining) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.age = age;
        this.gender = gender;
        this.dateOfJoining = dateOfJoining;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfJoining() { return dateOfJoining; }

    public void setDateOfJoining(LocalDate dateOfJoining) { this.dateOfJoining = dateOfJoining; }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }
}
