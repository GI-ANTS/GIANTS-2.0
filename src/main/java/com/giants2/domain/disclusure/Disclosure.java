package com.giants2.domain.disclusure;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
public class Disclosure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String rcpNo;

    private String corpCls;

    private String corpCode;

    private String corpName;

    private String flrNm;

    private String reportNm;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rceptDt;

    private String rm;

    private String stockCode;

    private LocalDateTime createdAt;
}
