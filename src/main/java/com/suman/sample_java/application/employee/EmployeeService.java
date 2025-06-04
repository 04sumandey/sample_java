package com.suman.sample_java.application.employee;

import com.suman.sample_java.domain.entity.Employee;

import java.util.UUID;


public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getEmployeeById(UUID id);
    Employee updateEmployeeById(UUID id, Employee employee);
    void deleteEmployeeById(UUID id);
}
