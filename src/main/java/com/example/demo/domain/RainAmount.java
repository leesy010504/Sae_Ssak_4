package com.example.demo.domain;

import jakarta.persistence.*;
@Entity
public class RainAmount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "input_id")
    private Long inputId;

    @Column
    private int year;

    @Column
    private String region;

    @Column
    private Long Jan;

    @Column
    private Long Feb;

    @Column
    private Long Mar;

    @Column
    private Long Apr;

    @Column
    private Long May;

    @Column
    private Long Jun;

    @Column
    private Long Jul;

    @Column
    private Long Aug;

    @Column
    private Long Sep;

    @Column
    private Long Oct;

    @Column
    private Long Nov;

    @Column
    private Long Dec;

    // 모든 필드를 초기화하는 생성자
    public RainAmount(String region, int year, Long jan, Long feb, Long mar, Long apr, Long may, Long jun, Long jul, Long aug, Long sep, Long oct, Long nov, Long dec) {
        this.region = region;
        this.year = year;
        this.Jan = jan;
        this.Feb = feb;
        this.Mar = mar;
        this.Apr = apr;
        this.May = may;
        this.Jun = jun;
        this.Jul = jul;
        this.Aug = aug;
        this.Sep = sep;
        this.Oct = oct;
        this.Nov = nov;
        this.Dec = dec;
    }

    public RainAmount() {
    }
}

