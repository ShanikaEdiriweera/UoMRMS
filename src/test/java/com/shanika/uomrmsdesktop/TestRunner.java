package com.shanika.uomrmsdesktop;

import com.shanika.uomrmsdesktop.DA.DBHandlerTest;
import com.shanika.uomrmsdesktop.DA.GetSemesterResultsTest;
import com.shanika.uomrmsdesktop.UI.SetDataFromDBTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Shanika Ediriweera
 */
public class TestRunner {
   public static void main(String[] args) {
      //Result result = JUnitCore.runClasses(DBHandlerTest.class,GetSemesterResultsTest.class);
      Result result = JUnitCore.runClasses(GetSemesterResultsTest.class);
      //Result result = JUnitCore.runClasses(DBHandlerTest.class);
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println(result.wasSuccessful());
   }
} 