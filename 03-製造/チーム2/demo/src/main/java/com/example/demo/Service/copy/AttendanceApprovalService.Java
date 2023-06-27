package service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.repository.AttendanceApprovalRepository;
/**
 * ユーザー情報 Service
 */
@Service
public class AttendanceApprovalService {
/**
* ユーザー情報 Repository
*/
@Autowired
	private AttendanceApprovalRepository AttendanceApprovalRepository;
	/**
	* ユーザー情報 全検索
	* @return 検索結果
	*/
	public List<AttendanceApproval> searchAll() {
	return AttendanceApprovalRepository.findAll();
	}
}
