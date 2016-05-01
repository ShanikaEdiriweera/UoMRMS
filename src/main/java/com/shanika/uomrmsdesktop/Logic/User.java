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
public abstract class User {
    private String ID;
    private String name;
    private Gender gender;
    private UserType userType;
    private Department department;
    
    public User(String ID, String name, Gender gender, UserType userType, Department department){
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.userType = userType;
        this.department = department;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public UserType getUserType() {
        return userType;
    }

    public Department getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
