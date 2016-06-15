/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shanika.uomrmsdesktop.DA;

import com.shanika.uomrmsdesktop.Logic.Module;
import com.shanika.uomrmsdesktop.Logic.Student;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author shanika
 */
public class GetModulesTest {
    @Test
    public void getStudentsTest(){
        //dummy data
        Module[] modules = DBHandler.getModules(2);
        for (Module module : modules) {
            System.out.println("module: "+module+" code: "+module.getmCode());
        }
        assertEquals(2,modules[0].getSemester().getID());
    }
}
