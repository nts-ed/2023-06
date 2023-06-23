package com.example.demo.Controller.copy;


import com.example.demo.DTO.copy.Employee_Summary;
import com.example.demo.Service.copy.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // 譟･謇�譛牙遭蟾･
    @GetMapping("/emps")
    public String list(Model model) {
        List<Employee_Summary> listEmployees = employeeService.listEmployees();
        System.out.println(listEmployees);
        model.addAttribute("emps", listEmployees);
        return "/Employees";
    }

    @PostMapping("/emp/updateSuccess")
    public String updateEmp(Employee_Summary employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/delete")
    public String delete(@RequestParam("id") String employeesId) {
        employeeService.deleteEmployee(employeesId);
        return "redirect:/emps";
    }

    @GetMapping("/emp/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/Employees.html";
    }
}