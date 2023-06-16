package com.example.demo.Controller.copy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.Syain;
import com.example.demo.Controller.copy.Employee;
import com.example.demo.Controller.copy.EmployeeRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired Syain syain;
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
	        Employee employee = employeeRepository.findByEmployee(employeeID);
	        if(employee == null|| employee.getDel_flg() == 1) {
	        	model.addAttribute("error", "社員は存在しません。");
	        	return "login";
	        }else if (!employee.getPassword().equals(password)&& employee.getDel_flg() == 0) {
	        	model.addAttribute("error", "パスワードがまちがっています。再度入力しなおしてください。");
	            return "login"; // Return to the login page with an error message
	        } else {
	        	syain.setiD(employeeID);
	        	syain.setName(employee.getEmployeeName());
	        	model.addAttribute(syain);
	            session.setAttribute("employeeName", employee.getEmployeeName());
	            session.setAttribute("employee_id", employee.getEmployeeID());
	            if (employee.getAdmin_flg() == 0) {
	                return "employeeDirectory";
	            } else if (employee.getAdmin_flg() == 1) {
	            	return "directory";
	            }
	        } 
	        
	        return "login";
	}
}
//String sql = "SELECT * "
//		+ "FROM group2.T_EMPLOYEE where EMPLOYEE_ID = '"+employeeID+"'";
////取得したDBを格納する
//Map<String, Object> map = jdbcTemplate.queryForMap(sql);
//if(map.get("EMPLOYEE_ID") == null) {
//	model.addAttribute("error", "社員は存在しません。");
//	return "login";
//}else if (!map.get("PASSWORD").equals(password)) {
//	model.addAttribute("error", "パスワードがまちがっています。再度入力しなおしてください。");
//    return "login"; // Return to the login page with an error message
//} else {
//    session.setAttribute("employeeName", map.get("EMPLOYEE_NAME"));
//    if ((int)map.get("ADMIN_FLG") == 0) {
//        return "employeeDirectory";
//    } else if ((int)map.get("ADMIN_FLG") == 1) {
//    	return "directory";
//    }
//} 
