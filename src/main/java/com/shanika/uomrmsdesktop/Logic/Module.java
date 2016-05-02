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
public class Module {
    private String mCode; 
    private String title;
    private Semester semester;
    private double credits;
    private boolean gpa;
    
    public Module(String mCode, String title, Semester semester, double credits, boolean gpa){
        this.mCode = mCode;
        this.title = title;
        this.semester  = semester;
        this.credits = credits;
        this.gpa = gpa;
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public boolean isGpa() {
        return gpa;
    }

    public void setGpa(boolean gpa) {
        this.gpa = gpa;
    }
    
    
}
