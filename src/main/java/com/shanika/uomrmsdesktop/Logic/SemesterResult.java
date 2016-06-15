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
public class SemesterResult {
    private int ID;
    private Student student;
    private Semester semester;
    private double sGPA;
    private int sRank;
    
    private double semCredits;
    private String studentId;
    private int semesterId;
    
    public SemesterResult(){
        
    }
    
    public SemesterResult(int ID, Student student, Semester semester, double sGPA, int sRank){
        this.ID = ID;
        this.student = student;
        this.semester = semester;
        this.sGPA = sGPA;
        this.sRank = sRank;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public double getsGPA() {
        return sGPA;
    }

    public void setsGPA(double sGPA) {
        this.sGPA = sGPA;
    }

    public int getsRank() {
        return sRank;
    }

    public void setsRank(int sRank) {
        this.sRank = sRank;
    }

    public int getID() {
        return ID;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getSemCredits() {
        return semCredits;
    }

    public void setSemCredits(double semCredits) {
        this.semCredits = semCredits;
    }
    
    
}
