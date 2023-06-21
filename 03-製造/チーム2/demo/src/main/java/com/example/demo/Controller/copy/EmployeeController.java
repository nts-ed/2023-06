package com.example.demo.Controller.copy;


//import com.example.staffingsystem.mapper.EmployeeMapper;
//import com.example.staffingsystem.pojo.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
//@Controller
//public class EmployeeController {
//
//    @Autowired
//    EmployeeMapper employeeMapper;
//
//    // 譟･謇�譛牙遭蟾･
//    @RequestMapping("/emps")
//    public String list(Model model) {
//
//        List<Employee> listEmployees = employeeMapper.list();
//        System.out.println(listEmployees);
//        model.addAttribute("emps", listEmployees);
//        return "/Employees";
//    }
//
//    @PostMapping("/emp/updateSuccess")
//    public String updateEmp(Employee employee) {
//        employeeMapper.updateEmployee(employee);
//        return "redirect:/emps";
//    }
//
//    @RequestMapping("/emp/delete")
//    public String delete(@RequestParam("id") String employeesId) {
//        employeeMapper.delete(employeesId);
//        return "redirect:/emps";
//    }
//
//    @RequestMapping("/emp/logout")
//    public String logout(HttpSession session) {
//        session.invalidate();
//        return "redirect:/Employees.html";
//    }
//}