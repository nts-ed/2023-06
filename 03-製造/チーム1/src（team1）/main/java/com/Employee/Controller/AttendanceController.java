package com.example.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
@Controller
public class AttendanceController {
 private final AttendanceRepository attendanceRepository;

 @Autowired
 public AttendanceController(AttendanceRepository attendanceRepository) {
     this.attendanceRepository = attendanceRepository;
 }

 @GetMapping("/")
 public String showAttendance(Model model) {
     LocalDate currentDate = LocalDate.now();
     List<AttendanceRepository> attendanceList = attendanceRepository.findByDate(currentDate);
     model.addAttribute("attendanceList", attendanceList);
     return "attendance";
*/
     
     
     @Controller
     public class AttendanceController {

         @GetMapping("/attendance/monthly")
         public String displayMonthlyAttendance() {
             // 勤怠情報一覧（月別）画面の表示ロジック
             return "monthly_attendance";
         }

         @GetMapping("/attendance/daily")
         public String displayDailyAttendance() {
             // 勤怠情報一覧（日別）画面の表示ロジック
             return "daily_attendance";
         }

         @GetMapping("/attendance")
         public String redirectToMonthlyAttendance() {
             return "redirect:/attendance/monthly";
         }
         
         
         @GetMapping("/attendance")
         public String displayAttendance() {
              // 勤怠情報一覧画面の表示ロジック
              return "attendance";
             }

          @GetMapping("/attendance/new")
          public String displayAttendanceFormForAdd() {
               // 勤怠情報追加画面の表示ロジック
              return "attendance_form";
             }

          @GetMapping("/attendance/edit")
          public String displayAttendanceFormForEdit() {
              // 勤怠情報修正画面の表示ロジック
              return "attendance_form";
         }
 }
