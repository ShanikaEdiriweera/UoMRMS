/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shanika.uomrmsdesktop.Logic;

import com.shanika.uomrmsdesktop.DA.DBHandler;

/**
 *
 * @author Shanika Ediriweera
 */
public class ModuleHandler {
    public static Module[] getAll(int semester) {
        Module[] modules = DBHandler.getModules(semester);
        return modules;
    }
    
}
