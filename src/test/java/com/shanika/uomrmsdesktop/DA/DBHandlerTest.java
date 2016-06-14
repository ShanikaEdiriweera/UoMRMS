/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shanika.uomrmsdesktop.DA;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Shanika Ediriweera
 */
public class DBHandlerTest {
    @Test
    public void getModulesTest() {
        Assert.assertNotNull(new DBHandler().getModules());
    }
    
    @Test
    public void getFacultiesTest() {
        Assert.assertNotNull(new DBHandler().getFaculties());
    }
    
    @Test
    public void getDepartmentsTest() {
        Assert.assertNotNull(new DBHandler().getDepartments());
    }
    
    @Test
    public void getSemestersTest() {
        Assert.assertNotNull(new DBHandler().getSemesters());
    }
    
    @Test
    public void getBatchesTest() {
        Assert.assertNotNull(new DBHandler().getBatches());
    }
}
