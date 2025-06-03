package com.suman.sample_java.application.employee;

import com.suman.sample_java.application.employee.dto.CreateEmployeeResponseDto;
import com.suman.sample_java.domain.entity.Employee;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
}
