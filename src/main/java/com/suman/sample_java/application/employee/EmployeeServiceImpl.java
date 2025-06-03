package com.suman.sample_java.application.employee;

import com.suman.sample_java.domain.entity.Employee;
import com.suman.sample_java.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


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
}


