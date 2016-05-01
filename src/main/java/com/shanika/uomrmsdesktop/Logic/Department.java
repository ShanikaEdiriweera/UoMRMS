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
public class Department {
    private int ID;
    private String name;
    private Faculty faculty;

    public Department(int ID, String name, Faculty faculty){
        this.ID = ID;
        this.name = name;
        this.faculty = faculty;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Faculty getFaculty() {
        return faculty;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
