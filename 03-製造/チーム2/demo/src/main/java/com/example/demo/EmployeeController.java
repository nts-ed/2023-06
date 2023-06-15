package com.example.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/index")
    public String getEmployee(Model model) {
        Employee employee = Employee.generateRandomEmployee();
        model.addAttribute("employee", employee);
        return "employee";
    }
}
