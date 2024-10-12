package com.Assignment.employee.service;

import com.Assignment.employee.exception.EmployeeNotFoundException;
import com.Assignment.employee.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new Employee(1002, "Ankit singh", "Ghaziabad"));
        employees.add(new Employee(1003, "Shivam", "delhi"));
        employees.add(new Employee(1004,"Rahul","Gandhi nagar"));
    }

    /** get all employee list*/
    public List<Employee> getAllEmployees() {
        return employees;
    }
    /** fing employee by their id*/
    public Employee getEmployeeById(int id) {
        return employees.stream()
                .filter(emp -> emp.getEmpId()==id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    /**Add new employee*/
    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    /**Delete employee by ID*/
    public void deleteEmployee(int id) {
        Employee employee = getEmployeeById(id);
        employees.remove(employee);
    }

    /** Update employee's address*/
    public Employee updateEmployeeAddress(int id, String newAddress) {
        Employee employee = getEmployeeById(id);
        employee.setAddress(newAddress);
        return employee;
    }
}