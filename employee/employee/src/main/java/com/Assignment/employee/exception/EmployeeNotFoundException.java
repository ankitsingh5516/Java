package com.Assignment.employee.exception;
/** Custom exception for employee not found*/
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
