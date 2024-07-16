package com.project.emsbackend.service;

import com.project.emsbackend.dto.EmployeeDto;
import com.project.emsbackend.entity.Employee;
import com.project.emsbackend.exception.ResourceNotFoundException;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long employeeId) throws ResourceNotFoundException;

    List<Employee> getAllEmployees();

    Employee updateEmployee(Long employeeId,Employee updatedEmployee) throws ResourceNotFoundException;

    void deleteEmployee(Long employeeId) throws ResourceNotFoundException;
}
