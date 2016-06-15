/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shanika.uomrmsdesktop.DA;

import com.shanika.uomrmsdesktop.Logic.ModuleGrade;
import com.shanika.uomrmsdesktop.Logic.SemesterResult;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author shanika
 */
public class GetModuleGradesTest {
    @Test
    public void getModuleGradesTest(){
        //dummy data
        ModuleGrade[] moduleGrades = DBHandler.getModuleGrades("130147J");
        for (ModuleGrade moduleGrade : moduleGrades) {
            System.out.println("modGrade: "+moduleGrade+" grade: "+moduleGrade.getGrade());
        }
        assertEquals("130147J",moduleGrades[0].getStudentID());
    }
}
