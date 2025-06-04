package com.suman.sample_java.application.employee;

import com.suman.sample_java.application.employee.dto.*;
import com.suman.sample_java.common.ResponseUtil.Util;
import com.suman.sample_java.common.ResponseUtil.dto.Response;
import com.suman.sample_java.domain.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final Util util;

    @PostMapping("/employee")
    public ResponseEntity<Response<CreateEmployeeResponseDto>> createEmployee(@RequestBody CreateEmployeeRequestDto dto) {
        try {
            Employee employee = Employee.builder()
                    .FirstName(dto.getFirstName())
                    .LastName(dto.getLastName())
                    .Email(dto.getEmail())
                    .Phone(dto.getPhone())
                    .build();

            Employee createdEmployee = employeeService.createEmployee(employee);

            CreateEmployeeResponseDto respDto = CreateEmployeeResponseDto.builder()
                    .id(createdEmployee.getId())
                    .firstName(createdEmployee.getFirstName())
                    .lastName(createdEmployee.getLastName())
                    .phone(createdEmployee.getPhone())
                    .email(createdEmployee.getEmail())
                    .build();

            return util.SuccessBuilder(respDto).toEntity();
        } catch (Exception e) {
            return util.<CreateEmployeeResponseDto>FailureBuilder(e).toEntity();
        }
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Response<GetEmployeeResponseDto>> getEmployee(@PathVariable UUID id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);

            GetEmployeeResponseDto responseDto = GetEmployeeResponseDto.builder()
                    .id(employee.getId())
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .phone(employee.getPhone())
                    .email(employee.getEmail())
                    .build();
            return util.SuccessBuilder(responseDto).toEntity();
        } catch (Exception e) {
            return util.<GetEmployeeResponseDto>FailureBuilder(e).toEntity();
        }
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Response<UpdateEmployeeResponseDto>> updateEmployee(
            @PathVariable UUID id,
            @RequestBody UpdateEmployeeRequestDto updateDto) {
        try {
            Employee employee = updateDto.MapToEmployeeEntity();
            Employee updatedEmployee = employeeService.updateEmployeeById(id, employee);

            UpdateEmployeeResponseDto responseDto = UpdateEmployeeResponseDto.builder()
                    .id(updatedEmployee.getId())
                    .firstName(updatedEmployee.getFirstName())
                    .lastName(updatedEmployee.getLastName())
                    .phone(updatedEmployee.getPhone())
                    .email(updatedEmployee.getEmail())
                    .build();
            return util.SuccessBuilder(responseDto).toEntity();
        } catch (Exception e) {
            return util.<UpdateEmployeeResponseDto>FailureBuilder(e).toEntity();
        }
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Response<DeleteEmployeeResponseDto>> deleteEmployee(@PathVariable UUID id) {
        try {
            employeeService.deleteEmployeeById(id);
            DeleteEmployeeResponseDto responseDto = DeleteEmployeeResponseDto.builder()
                    .message("Employee deleted successfully")
                    .build();

            return util.SuccessBuilder(responseDto).toEntity();
        }catch(Exception e){
            return util.<DeleteEmployeeResponseDto>FailureBuilder(e).toEntity();
        }
}

}