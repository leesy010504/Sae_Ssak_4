package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollment_id;

    @Column
    private Long rain;

    @Column
    private Long temperature;

    protected Input() {}

    // 생성자
    public Input(Long rain, Long temperature) {
        this.rain = rain;
        this.temperature = temperature;
    }

    public Long getTemperature() {
        return temperature;
    }

    public void setTemperature(Long temperature) {
        this.temperature = temperature;
    }

    public Long getRain() {
        return rain;
    }

    public void setRain(Long rain) {
        this.rain = rain;
    }

    public Long getEnrollment_id() {
        return enrollment_id;
    }

    public void setEnrollment_id(Long enrollment_id) {
        this.enrollment_id = enrollment_id;
    }
}
