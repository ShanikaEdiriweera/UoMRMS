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
    
    public Student(String ID, String name, Gender gender, UserType userType, Department department) {
        super(ID, name, gender, userType, department);
        cGPA = 0.0;
        rank = 0;
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
    
    
}
