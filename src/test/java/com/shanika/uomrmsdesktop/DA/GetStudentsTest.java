/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shanika.uomrmsdesktop.DA;

import com.shanika.uomrmsdesktop.Logic.Student;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author shanika
 */
public class GetStudentsTest {
    @Test
    public void getStudentsTest(){
        //dummy data
        Student[] students = DBHandler.getStudents("Engineering",  "Computer Science & Engineering", 2013);
        for (Student student : students) {
            System.out.println("student: "+student+" name: "+student.getName());
        }
        assertEquals(13,students[0].getBatch());
    }
}
