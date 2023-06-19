package com.example.demo.DTO.copy;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.copy.Prefectures_Month;
import com.example.demo.Repository.copy.PrefecturesRepository_Month;

@Service
public class Service_Month {
	   @Autowired
	     PrefecturesRepository_Month prefecturesRepository;
	   
	   
	   
	    /**
	     * 驛ｨ髢�繝槭せ繧ｿ 蜈ｨ讀懃ｴ｢
	     * @return 讀懃ｴ｢邨先棡
	     */
	    public List<Prefectures_Month> getPrefecturesAll(String year) {
	    	List<Prefectures_Month> list = prefecturesRepository.findAllByYear(year);
	        return list;
	    }
}