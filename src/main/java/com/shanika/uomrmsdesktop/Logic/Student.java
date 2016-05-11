/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shanika.uomrmsdesktop.Logic;

/**
 *
 * @author Shanika Ediriweera
 */
public class Student extends User{
    private double cGPA;
    private int rank;
    private String batch;
    
    public Student(String ID, String name, Gender gender, UserType userType, Department department, String batch) {
        super(ID, name, gender, userType, department);
        cGPA = 0.0;
        rank = 0;
        this.batch = batch; 
    }

    public double getcGPA() {
        return cGPA;
    }

    public void setcGPA(double cGPA) {
        this.cGPA = cGPA;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
    
    
}
