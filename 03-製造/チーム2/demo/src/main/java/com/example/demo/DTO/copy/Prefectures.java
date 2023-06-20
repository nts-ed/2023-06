package com.example.demo.DTO.copy;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "group2.M_DEPT")
//@NamedQuery(name = "myFindByAge", query = "select * from TEST01.M_DEPT")
public class Prefectures implements Serializable{
    /**
     * 部門ID
     */
    @Id
    @Column(name = "DEPT_ID")
    private String DEPT_ID;
    /**
     * 部門名称
     */
    @Column(name = "DEPT_NAME")
    private String DEPT_NAME;
}
