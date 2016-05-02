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
public class UniversityAdmin extends User{
    
    public UniversityAdmin(String ID, String name, Gender gender, UserType userType, Department department) {
        super(ID, name, gender, userType, department);
    }
    
}
