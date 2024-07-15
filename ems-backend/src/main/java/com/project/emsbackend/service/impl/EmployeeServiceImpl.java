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
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.maptoEmployee(employeeDto);
        Employee saveEmployee= employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(saveEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) throws ResourceNotFoundException {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id : "+employeeId));
        return EmployeeMapper.maptoEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.maptoEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) throws ResourceNotFoundException {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee is not exists with given id:"+employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee UpdatedemployeeObj=employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(UpdatedemployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) throws ResourceNotFoundException {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id : "+employeeId));
        employeeRepository.deleteById(employeeId);
    }
}
