package com.suman.sample_java.application.employee;

import com.suman.sample_java.common.exceptions.ResourceNotFoundException;
import com.suman.sample_java.domain.entity.Employee;
import com.suman.sample_java.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        try {
            return employeeRepository.save(employee);
        } catch (Exception e) {
            System.err.println(e);
            throw e;
        }
    }

    public Employee getEmployeeById(UUID id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        return employee;
    }

    public Employee updateEmployeeById(UUID id, Employee employee) {
        Employee currentEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist"));

        currentEmployee.setFirstName(employee.getFirstName());
        currentEmployee.setLastName(employee.getLastName());
        currentEmployee.setPhone(employee.getPhone());
        currentEmployee.setEmail(employee.getEmail());

        Employee updatedEmployee = employeeRepository.save(currentEmployee);
        return updatedEmployee;
    }

    public void deleteEmployeeById(UUID id) {
        employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist"));
       
        employeeRepository.deleteById(id);
    }
}
