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
public class ModuleGrade {
    //private final int ID;
    private Student student;
    private String studentID;
    private Module module;
    private String moduleCode;
    private Semester semester;
    private String semesterName;
    private int semesterId;
    //private Grade grade;
    private String grade;
    
    public ModuleGrade(Student student, Module module, Semester semester, String grade){
        //this.ID = ID;
        this.student = student;
        this.module = module;
        this.semester = semester;
        this.grade = grade;
    }
    
    public ModuleGrade(String studentID, Module module, String semesterName, String grade){
        this.studentID = studentID;
        this.module = module;
        this.semesterName = semesterName;
        this.grade = grade;
    }
    
    public ModuleGrade(String studentID, String moduleCode, int semesterId, String grade){
        this.studentID = studentID;
        this.moduleCode = moduleCode;
        this.semesterId = semesterId;
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }
    
}
