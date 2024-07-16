package com.project.emsbackend.controller;

import com.project.emsbackend.entity.Employee;
import com.project.emsbackend.exception.ResourceNotFoundException;
import com.project.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
public class EmployeeeController {
    @Autowired
    private EmployeeService employeeService;

    //Add Employee
    @PostMapping("/employees")
    public String saveEmployee( @ModelAttribute("employee") Employee employee){
        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/new")
    public String createEmployeeForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "create_employee";
    }
    //Get Employee

    @GetMapping("/employees/edit/{id}")
    public String getEmployeeById(@PathVariable("id") Long employeeId,Model model) throws ResourceNotFoundException {
        model.addAttribute("employee",employeeService.getEmployeeById(employeeId));
        return "edit_employee";
    }

    // Get All Employees

    @GetMapping("/employees")
    public String listEmployee(Model model){
       model.addAttribute("employees",employeeService.getAllEmployees());
        return "employees";
    }

    // Update Employee
    @PutMapping("/employees/{id}")
    public String updateEmployee(@PathVariable("id") Long employeeId,@ModelAttribute("employee") Employee updateEmployee,Model model) throws ResourceNotFoundException {
        employeeService.updateEmployee(employeeId,updateEmployee);
        return "redirect:/employees";
    }

    //delete Employee
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable("id") Long employeeId) throws ResourceNotFoundException {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employees";
    }
}
