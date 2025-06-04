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
                    .LastName(dto.getLastname())
                    .Email(dto.getEmail())
                    .Phone(dto.getPhone())
                    .build();

            Employee createdEmployee = employeeService.createEmployee(employee);

            CreateEmployeeResponseDto respDto = CreateEmployeeResponseDto.builder()
                    .Id(createdEmployee.getId())
                    .FirstName(createdEmployee.getFirstName())
                    .Lastname(createdEmployee.getLastName())
                    .Phone(createdEmployee.getPhone())
                    .Email(createdEmployee.getEmail())
                    .build();

            return util.SuccessBuilder(respDto).toEntity();
        } catch (Exception e) {
            return util.<CreateEmployeeResponseDto>FailureBuilder(e).toEntity();
        }
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Response<GetEmployeeResponseDto>> getEmployee(@PathVariable UUID id) {
        try {
            GetEmployeeResponseDto responseDto = employeeService.getEmployeeById(id);
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
            UpdateEmployeeResponseDto updatedEmployee = employeeService.updateEmployeeById(id, updateDto);
            return util.SuccessBuilder(updatedEmployee).toEntity();
        } catch (Exception e) {
            return util.<UpdateEmployeeResponseDto>FailureBuilder(e).toEntity();
        }
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Response<DeleteEmployeeResponseDto>> deleteEmployee(@PathVariable UUID id) {
        try {
            DeleteEmployeeResponseDto deletedEmployee = employeeService.deleteEmployeeById(id);
                return util.SuccessBuilder(deletedEmployee).toEntity();
        }catch(Exception e){
            return util.<DeleteEmployeeResponseDto>FailureBuilder(e).toEntity();
        }
}

}