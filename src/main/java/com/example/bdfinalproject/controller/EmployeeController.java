package com.example.bdfinalproject.controller;


import com.example.bdfinalproject.dto.EmployeeDto;
import com.example.bdfinalproject.model.Employee;
import com.example.bdfinalproject.service.EmployeeService;
import com.example.bdfinalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        model.addAttribute("list", employeeService.getAllEmployees());
        return "employees";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        return "newEmployee";
    }



    @PostMapping("/addEmployee")
    public String saveTable(@ModelAttribute("employee") EmployeeDto employeeDto) {
        employeeService.save(employeeDto);
        return "redirect:/employees";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteTable(@PathVariable(value = "id") long id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

    @GetMapping("/updateEmployee/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        EmployeeDto employeeDto = new EmployeeDto(id, employee.getFirstName(), employee.getLastName(), employee.getPhoneNumber());
        model.addAttribute("employee", employeeDto);
        return "updateEmployee";
    }

    @PostMapping("/updatedEmployee")
    public String updateTable(@ModelAttribute("table") EmployeeDto employeeDto) {
        employeeService.update(employeeDto);
        return "redirect:/employees";
    }


}
