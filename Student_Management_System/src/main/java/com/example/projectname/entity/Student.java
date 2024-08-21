package com.example.projectname.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "student_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long studid;

    @Column(name = "studentname")
    private String studName;

    @Column(name = "fee")
    private double fee;

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(String studName, double fee) {
        this.studName = studName;
        this.fee = fee;
    }

    // Getters and Setters
    public long getStudid() {
        return studid;
    }

    public void setStudid(long studid) {
        this.studid = studid;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studid=" + studid +
                ", studName='" + studName + '\'' +
                ", fee=" + fee +
                '}';
    }
}

