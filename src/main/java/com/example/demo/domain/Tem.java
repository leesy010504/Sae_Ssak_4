package com.example.demo.domain;

import jakarta.persistence.*;
@Entity
public class Tem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long input_id;

    @Column
    private int Year;

    @Column
    private String Location;

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

    public Tem(String location, int year, Long jan, Long feb, Long mar, Long apr, Long may, Long jun, Long jul, Long aug, Long sep, Long oct, Long nov, Long dec) {
        this.Location = location;
        this.Year = year;
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

    public Tem() {
    }
}

