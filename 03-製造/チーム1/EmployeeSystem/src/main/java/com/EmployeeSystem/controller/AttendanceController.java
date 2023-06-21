package com.EmployeeSystem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.EmployeeSystem.dto.AttendanceDTO;
import com.EmployeeSystem.service.AttendanceService;
import java.util.List;

@Controller
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping
    public String getAttendanceDataForIdAndDate(@RequestParam("id") Integer id, @RequestParam("date") String date, Model model) {
        List<AttendanceDTO> attendanceData = attendanceService.getAttendanceDataForIdAndDate(id, date);
        for (AttendanceDTO attendance : attendanceData) {
            System.out.println(attendance.toString());
        }
        model.addAttribute("attendanceData", attendanceData);
        return "aa/text"; // 返回逻辑视图名称
    }
    @PostMapping("/updateStatus")
    public ResponseEntity<String> updateAttendanceStatus(@RequestBody AttendanceDTO request) {
        String action = request.getAction(); // 直接获取前端传递的 action 值
        attendanceService.updateAttendanceStatus(request.getId(), request.getDate(), action);
        System.out.println("Received request. id: " + request.getId() + ", date: " + request.getDate() + ", action: " + action);
        return ResponseEntity.ok("Update successful");
    }
}