package com.Assignment.employee.controller;

import com.Assignment.employee.exception.EmployeeNotFoundException;
import com.Assignment.employee.model.Employee;
import com.Assignment.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/getEmployee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
            return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**Get employee by ID*/
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            throw new EmployeeNotFoundException("Employee ID- " + id + " is not found");
        }
    }

    /**Add new employee*/
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/address")
    public ResponseEntity<Employee> updateEmployeeAddress(@PathVariable int id, @RequestBody String newAddress) {
        Employee updatedEmployee = employeeService.updateEmployeeAddress(id, newAddress);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
}
