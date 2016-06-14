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
    private String username;
    private String password;
    private String name;
    private Gender gender;
    private UserType userType;
    private Department department;
    private String state;
    
    public User(String ID, String username, String password, String name, Gender gender, UserType userType, Department department, String state){
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.userType = userType;
        this.department = department;
        this.state = state;
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

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
