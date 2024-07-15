package com.project.emsbackend.service;

import com.project.emsbackend.dto.EmployeeDto;
import com.project.emsbackend.exception.ResourceNotFoundException;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId) throws ResourceNotFoundException;

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployee) throws ResourceNotFoundException;

    void deleteEmployee(Long employeeId) throws ResourceNotFoundException;
}
