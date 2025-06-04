package com.suman.sample_java.application.employee;

import com.suman.sample_java.application.employee.dto.DeleteEmployeeResponseDto;
import com.suman.sample_java.application.employee.dto.GetEmployeeResponseDto;
import com.suman.sample_java.application.employee.dto.UpdateEmployeeRequestDto;
import com.suman.sample_java.application.employee.dto.UpdateEmployeeResponseDto;
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
    public GetEmployeeResponseDto getEmployeeById(UUID id) {
        Employee employee = employeeRepository.findById(id).
        orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        return GetEmployeeResponseDto.builder()
            .id(id)
            .FirstName(employee.getFirstName())
            .LastName(employee.getLastName())
            .Phone(employee.getPhone())
            .Email(employee.getEmail())
            .build();
    }
    public UpdateEmployeeResponseDto updateEmployeeById(UUID id, UpdateEmployeeRequestDto updateDto) {
        Employee employee = employeeRepository.findById(id).
        orElseThrow(() -> new ResourceNotFoundException("Employee does not exist"));
             employee.setId(id);
             employee.setFirstName(updateDto.getFirstName());
             employee.setLastName(updateDto.getLastName());
             employee.setPhone(updateDto.getPhone());
             employee.setEmail(updateDto.getEmail());

             Employee updatedEmployee = employeeRepository.save(employee);
            return UpdateEmployeeResponseDto.builder()
            .id(id)
            .FirstName(updatedEmployee.getFirstName())
            .LastName(updatedEmployee.getLastName())
            .Phone(updatedEmployee.getPhone())
            .Email(updatedEmployee.getEmail())
            .build();
    }

    public DeleteEmployeeResponseDto deleteEmployeeById(UUID id){
        Employee employee =employeeRepository.findById(id).
                            orElseThrow(()-> new ResourceNotFoundException("Employee does not exist"));
                            employeeRepository.deleteById(id);
                            return DeleteEmployeeResponseDto.builder()
                            .message("Employee Deleted Successfully")
                            .build();
    }
}


