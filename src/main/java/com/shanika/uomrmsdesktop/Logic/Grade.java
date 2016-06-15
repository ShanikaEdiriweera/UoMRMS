package com.shanika.uomrmsdesktop.Logic;

import com.shanika.uomrmsdesktop.DA.DBHandler;

/**
 *
 * @author Shanika Ediriweera
 */
//check whether working without get method
//enum to keep grades and marks
//public enum Grade {
//    A_plus(4.2),
//    A_(4.0),
//    A_minus(3.7),
//    B_plus(3.3),
//    B(3.0),
//    B_minus(2.7),
//    C_plus(2.3),
//    C(2.0),
//    C_minus(1.5),
//    D(1.0),
//    F(0.0),
//    I_we(0.0),
//    I_ca(0.0),
//    ab(0.0);
//
//    //get from db
//    public static Grade[] getAll() {
//        Grade[] grades = null;
//        return grades;
//    }
//    
//    private double mark;
//    
//    private Grade(double mark){
//        this.mark = mark;
//    }
//    
////    public double mark(){
////        return mark;
////    }
//}

public class Grade{
    private String grade;
    private double mark;

    public Grade(String grade, double mark) {
        this.grade = grade;
        this.mark = mark;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    //from db
    public static Grade[] getAll() {
        Grade[] grades = DBHandler.getGrades();
        return grades;
    }
}