package controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import entity.AttendanceApproval;
import service.AttendanceApprovalService;
/**
 * ユーザー情報 Controller
 */
@Controller
public class AttendanceApprovalController {
  /**
   * ユーザー情報 Service
   */
  @Autowired
  private AttendanceApprovalService AttendanceApprovalService;
  /**
   * ユーザー情報一覧画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @GetMapping(value = "/AttendanceApproval/list")
  public String displayList(Model model) {
    List<AttendanceApproval> userlist = AttendanceApprovalService.searchAll();
    model.addAttribute("AttendanceApprovallist", AttendanceApprovalService);
    return "AttendanceApproval/list";
  }
  /**
   * ユーザー新規登録画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @GetMapping(value = "/AttendanceApproval/add")
  public String displayAdd(Model model) {
    return "AttendanceApproval/add";
  }
  /**
   * ユーザー情報詳細画面を表示
   * @param id 表示するユーザーID
   * @param model Model
   * @return ユーザー情報詳細画面
   */
  @GetMapping("/AttendanceApproval/{id}")
  public String displayView(@PathVariable Long id, Model model) {
    return "AttendanceApproval/view";
  }
}