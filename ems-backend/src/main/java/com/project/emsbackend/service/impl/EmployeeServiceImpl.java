package com.project.emsbackend.service.impl;

import com.project.emsbackend.dto.EmployeeDto;
import com.project.emsbackend.entity.Employee;
import com.project.emsbackend.exception.ResourceNotFoundException;
import com.project.emsbackend.mapper.EmployeeMapper;
import com.project.emsbackend.repository.EmployeeRepository;
import com.project.emsbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee createEmployee(Employee employee) {
        //Employee employee= EmployeeMapper.maptoEmployee(employeeDto);
        Employee saveEmployee= employeeRepository.save(employee);
        // EmployeeMapper.maptoEmployeeDto(saveEmployee);
        return saveEmployee;
    }

    @Override
    public Employee getEmployeeById(Long employeeId) throws ResourceNotFoundException {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id : "+employeeId));
        //return EmployeeMapper.maptoEmployeeDto(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        //return employees.stream().map((employee) -> EmployeeMapper.maptoEmployeeDto(employee)).collect(Collectors.toList());
        return employees;
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee updatedEmployee) throws ResourceNotFoundException {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee is not exists with given id:"+employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedemployeeObj=employeeRepository.save(employee);
        //return EmployeeMapper.maptoEmployeeDto(UpdatedemployeeObj);
        return updatedemployeeObj;
    }

    @Override
    public void deleteEmployee(Long employeeId) throws ResourceNotFoundException {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id : "+employeeId));
        employeeRepository.deleteById(employeeId);
    }
}
