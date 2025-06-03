package com.suman.sample_java.application.employee;

import com.suman.sample_java.application.employee.dto.CreateEmployeeRequestDto;
import com.suman.sample_java.application.employee.dto.CreateEmployeeResponseDto;
import com.suman.sample_java.common.ResponseUtil.Util;
import com.suman.sample_java.common.ResponseUtil.dto.Response;
import com.suman.sample_java.domain.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

            CreateEmployeeResponseDto respDto= CreateEmployeeResponseDto.builder()
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

}
