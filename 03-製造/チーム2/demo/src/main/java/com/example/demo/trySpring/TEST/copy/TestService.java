package com.example.demo.trySpring.TEST.copy;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.trySpring.TEST.copy.Prefectures;
import com.example.demo.trySpring.TEST.copy.PrefecturesRepository;

@Service
public class TestService {
	   @Autowired
	     PrefecturesRepository prefecturesRepository;
	   
	   
	   
	    /**
	     * 部門マスタ 全検索
	     * @return 検索結果
	     */
	    public List<Prefectures> getPrefecturesAll() {
//	    	Prefectures pre = new Prefectures();
//	    	pre.setDEPT_ID("1");
//	    	pre.setDEPT_NAME("5");
//	    	List<Prefectures> list = new ArrayList<Prefectures>();
//	    	return list;
	        return prefecturesRepository.findAll();
	    }
}
