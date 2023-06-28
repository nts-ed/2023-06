package jsp_demo_001;
import com.serviceImpl.TorokuServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
	@WebServlet("/TorokuServlet")
	public class TorokuServlet extends Servlet {
		
		TorokuService torokuService = new TorokuServiceImpl();
	   
	    @Override
	    protected void doPost(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
	        req.setCharacterEncoding("utf-8");
	        resp.setCharacterEncoding("utf-8");
	        resp.setContentType("text/html;charset=utf-8");
	        
	        String attendance_date = req.getParameter("attendance_date");//日付
	        String start_time = req.getParameter("start_time");//出勤時間
	        String end_time = req.getParameter("end_time");//退勤時間
	        String rest_hours = req.getParameter("rest_hours");//休憩時間
	        String status_id = req.getParameter("status_id");//状態
	        String remarks = req.getParameter("remarks");//作業内容
	        
	        
	        System.out.println( attendance_date +":"+ start_time +":"+ end_time + ":" + rest_hours +":" + status_id + ""
	        		+ ":" + remarks);
	        Toroku toroku = new Toroku();
	        toroku.setAttendance_date(Integer.parseInt(attendance_date));

	        toroku.setStart_time(start_time);
	        toroku.setEnd_time(end_time);
	        toroku.setRest_hours(rest_hours);
	        toroku.setStatus_id(status_id);
	        toroku.setRemarks(remarks);
	        
	        int i = torokuService.inserttoroku(toroku);
	        if(i > 0){
	            System.out.println("登録成功");
	          
	            List<Toroku> list = TorokuService.torokuList();// list
	         
            req.setAttribute("ls",list);
            
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else {
            System.out.println("登録失败");
           
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }

       }
	}