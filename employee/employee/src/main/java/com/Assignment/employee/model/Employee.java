package com.Assignment.employee.model;

import org.springframework.web.bind.annotation.RequestMapping;

/** Employee class*/
@RequestMapping("/getEmployee")
public class Employee {
    private int empId;
    private String name;
    private String address;
    /** Employee constructor */
    public Employee(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }
    /** Getter and setter methods*/
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
