package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	 @Autowired
	    private EmployeeRepository employeeRepository;

	    @GetMapping("/login")
	    public String showLoginForm() {
	        return "login";
	    }

	    @PostMapping("/login")
	    public String processLogin(@RequestParam("employeeID") String employeeID,
	                               @RequestParam("password") String password,
	                               HttpSession session,
	                               Model model) {
	        Employee employee = employeeRepository.findByEmployeeID(employeeID);
	        if(employee == null || employee.getDel_flg() == 1) {
	        	model.addAttribute("error", "社員は存在しません。");
	        	return "login";
	        }else if (!employee.getPassword().equals(password) && employee.getDel_flg() == 0) {
	        	model.addAttribute("error", "パスワードがまちがっています。再度入力しなおしてください。");
	            return "login"; // Return to the login page with an error message
	        } else {
	            session.setAttribute("employeeName", employee.getEmployeeName());
	            if (employee.getAdmin_flg() == 0) {
	                return "redirect:/employeeDirectory";
	            } else if (employee.getAdmin_flg() == 1) {
	            	return "redirect:/directory";
	            }
	        } 
	        return "login";
			
      	
	}
}
