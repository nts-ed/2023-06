package com.example.demo.trySpring.copy;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.trySpring.copy.SyainDto;
import com.example.demo.trySpring.copy.SyainRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SyainService {
	private final SyainRepository syainRepository;

	@Transactional
	public void updateData() {
		// 登録データの作成
		List<SyainDto> syainList = new ArrayList<>();
		LocalDateTime dateTimeNow = LocalDateTime.now();

//		syainList.add(new SyainDto(
//				"1", "鈴木", "suzuki","absaeaa@gmail.com",dateTimeNow,dateTimeNow));
//		syainList.add(new SyainDto(
//				"2", "田中", "tanaka","ggges@gmail.com",dateTimeNow,dateTimeNow));
//		syainList.add(new SyainDto(
//				"3", "佐藤", "sato","afefsa@gmail.com",dateTimeNow,dateTimeNow));
		//syainList.add(new SyainDto(
				//1, "鈴木", "suzuki",dateTimeNow,dateTimeNow));
		//syainRepository.updateSyain(); // 更新
		//syainRepository.insertSyain(syainList); // 登録
		//syainRepository.deleteSyain(syainList.get(0)); // 削除
	}
}
