package com.example.demo.Repository.copy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.DTO.copy.Prefectures;
import java.util.List;
@Repository
public interface  PrefecturesRepository extends JpaRepository<Prefectures, Long>{
@Query(value = "select * from group2.M_DEPT ", nativeQuery = true)
List<Prefectures> findAll();


}