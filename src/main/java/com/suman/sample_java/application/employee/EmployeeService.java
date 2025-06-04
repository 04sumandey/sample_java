package com.suman.sample_java.application.employee;

import com.suman.sample_java.application.employee.dto.CreateEmployeeResponseDto;
import com.suman.sample_java.application.employee.dto.DeleteEmployeeResponseDto;
import com.suman.sample_java.application.employee.dto.GetEmployeeResponseDto;
import com.suman.sample_java.application.employee.dto.UpdateEmployeeRequestDto;
import com.suman.sample_java.application.employee.dto.UpdateEmployeeResponseDto;
import com.suman.sample_java.domain.entity.Employee;

import java.util.UUID;


public interface EmployeeService {
    Employee createEmployee(Employee employee);
    GetEmployeeResponseDto getEmployeeById(UUID id);
    UpdateEmployeeResponseDto updateEmployeeById(UUID id, UpdateEmployeeRequestDto updateDto);
    DeleteEmployeeResponseDto deleteEmployeeById(UUID id);
}
