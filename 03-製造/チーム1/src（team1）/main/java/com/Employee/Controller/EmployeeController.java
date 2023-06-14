package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    private final DataSource dataSource;

    public EmployeeController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/employee")
    public String getEmployeeData(Model model) {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  t_attendance_ym");

            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                int workHours = resultSet.getInt("work_hours");
                int overtimeHours = resultSet.getInt("overtime_hours");

                employees.add(new Employee(employeeId, workHours, overtimeHours));
            }

            model.addAttribute("employees", employees);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "employee";
    }
}
