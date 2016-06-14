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
public class SystemAdmin extends User{
    
    public SystemAdmin(String ID, String username, String password, String name, Gender gender, UserType userType, Department department, String state) {
        super(ID, username,password, name, gender, userType, department,state);
    }
    
}
