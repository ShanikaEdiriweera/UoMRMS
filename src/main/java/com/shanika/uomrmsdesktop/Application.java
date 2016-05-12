package com.shanika.uomrmsdesktop;

import com.shanika.uomrmsdesktop.UI.ExamDivUI;
import com.shanika.uomrmsdesktop.UI.ExaminationUI;

/**
 *
 * @author Shanika Ediriweera
 */
public class Application {
    public static void main(String args[]) {
        ExaminationUI program = new ExaminationUI();
        
        //running UI using the displayUI method
        program.displayUI();
        
        //creating a new thread of UI
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                program.setVisible(true);
//            }
//        });
        
    }
}
