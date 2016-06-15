/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shanika.uomrmsdesktop.DA;

import com.shanika.uomrmsdesktop.Logic.SemesterResult;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author shanika
 */
public class GetSemesterResultsTest {
    @Test
    public void getSemesterResultsTest(){
        //dummy data
        SemesterResult[] semesterResults = DBHandler.getSemesterResults("Engineering", "Computer Science & Engineering", 2013, 2);
        for (SemesterResult semesterResult : semesterResults) {
            System.out.println("semResult: "+semesterResult+" gpa: "+semesterResult.getsGPA());
        }
        assertEquals(1,semesterResults.length);
    }
}
