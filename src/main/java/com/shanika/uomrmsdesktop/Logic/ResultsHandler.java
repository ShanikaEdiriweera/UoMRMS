package com.shanika.uomrmsdesktop.Logic;

import com.shanika.uomrmsdesktop.DA.DBHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author Shanika Ediriweera
 */
public class ResultsHandler {

    
    public String resultsFilePath = "Results.xlsx";
    
    //add test
    //method to return ModuleGrade array
    public ModuleGrade[] setModuleGrades(String moduleCode, int semesterId, String textBoxString){
        List moduleGrades = new ArrayList();
        String[] textBoxArray = textBoxString.split("([ ]|[\n])");
        String studentId = "";
        String grade = "";
        
        int counter = 1;

        for(String textBoxElement : textBoxArray){
            //textBoxArray has both ids and grades
            if(counter%2 == 1){
                studentId = textBoxElement;
            }else{
                grade = textBoxElement;
                
                //creating Modulegrade object
                ModuleGrade moduleGrade = new ModuleGrade(studentId, moduleCode, semesterId, grade);
                moduleGrades.add(moduleGrade);
            }
            counter++;
        }
        return (ModuleGrade[]) moduleGrades.toArray(new ModuleGrade[moduleGrades.size()]);
    }
    
    //add test
    //method to get data from Excel sheet
    /**
     *
     * @param resultsFilePath
     * @return
     */
    public String getDataFromExcel(String resultsFilePath){
        String resultsString = "";
        FileInputStream file = null; 
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;
        try {
            file = new FileInputStream(new File(resultsFilePath));
            
            //Create Workbook instance holding reference to .xlsx file
            workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            sheet = workbook.getSheetAt(0);
            
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
                //add cell value to the results string
                resultsString = resultsString + row.getCell(0).getStringCellValue()+" ";
                resultsString = resultsString + row.getCell(1).getStringCellValue()+"\n";
                
//                //For each row, iterate through all the columns
//                Iterator<Cell> cellIterator = row.cellIterator();
//                while (cellIterator.hasNext()) 
//                {
//                    Cell cell = cellIterator.next();
//                    //add cell value to the results string
//                    resultsString = resultsString + cell.getStringCellValue()+" ";
//                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ResultsHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ResultsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(file != null){
                try {
                    file.close();
                } catch (IOException ex) {
                    Logger.getLogger(ResultsHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return resultsString;
    }
    
    public static SemesterResult[] getSemesterResults(String faculty, String department, int batch, int semester){
        SemesterResult[] semesterResults = DBHandler.getSemesterResults(faculty, department, batch, semester);
        
        return semesterResults;
    }
    
    
    public static SemesterResult[] getSemesterResults(String faculty, String department, int batch) {
        SemesterResult[] semesterResults = DBHandler.getSemesterResults(faculty, department, batch);
        
        return semesterResults;
    }
    
    //get from db
    public static ModuleGrade[] getModuleGrades(String id) {
        ModuleGrade[] moduleGrades = DBHandler.getModuleGrades(id);
        return moduleGrades;
    }
    
}
