package com.shanika.uomrmsdesktop;

import com.shanika.uomrmsdesktop.UI.ExamDivUI;
import com.shanika.uomrmsdesktop.UI.ExaminationUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shanika Ediriweera
 */
public class Application {
    public static void main(String args[]) {
        ExaminationUI program = new ExaminationUI();
        
        //running UI using the displayUI method
        program.displayUI(args);
        
        //creating a new thread of UI
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                program.setVisible(true);
//            }
//        });
        
    }
}
