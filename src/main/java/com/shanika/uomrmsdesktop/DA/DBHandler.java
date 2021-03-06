/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shanika.uomrmsdesktop.DA;

import com.shanika.uomrmsdesktop.Logic.Department;
import com.shanika.uomrmsdesktop.Logic.Faculty;
import com.shanika.uomrmsdesktop.Logic.Gender;
import com.shanika.uomrmsdesktop.Logic.Grade;
import com.shanika.uomrmsdesktop.Logic.Module;
import com.shanika.uomrmsdesktop.Logic.ModuleGrade;
import com.shanika.uomrmsdesktop.Logic.Semester;
import com.shanika.uomrmsdesktop.Logic.SemesterResult;
import com.shanika.uomrmsdesktop.Logic.Student;
import com.shanika.uomrmsdesktop.Logic.UserType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shanika Ediriweera
 */
public class DBHandler {

    private Statement statement;
    private static ResultSet resultSet;
    private static MysqlConnect db;

    public DBHandler()  {
        db = MysqlConnect.getMysqlConnect();
    }

    public int setData(String sql)  {
        try {
            statement = db.getDBConnection().createStatement();
            int result = statement.executeUpdate(sql);
            return result;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ResultSet getData(String sql) {
        try {
            statement = db.getDBConnection().createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }

    public static int setData(PreparedStatement preparedStatement)  {
        try {
            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static ResultSet getData(PreparedStatement preparedStatement) {
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }

    //method to get modules
    public String[] getModules(){
        List moduleArray = new ArrayList();

        try {
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT DISTINCT code FROM Module");
            ResultSet resultSet = getData(preparedStatement);

            while (resultSet.next()) {
                moduleArray.add(resultSet.getString(1));
            }
            // convert to a string array
            return (String[]) moduleArray.toArray(new String[moduleArray.size()]);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //method to get Semesters
    public String[] getSemesters(){
        List semesterArray = new ArrayList();

        try {
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT name FROM Semester");
            ResultSet resultSet = getData(preparedStatement);

            while (resultSet.next()) {
                semesterArray.add(resultSet.getString(1));
            }
            // convert to a string array
            return (String[]) semesterArray.toArray(new String[semesterArray.size()]);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //method to get faculties
    public String[] getFaculties(){
        List facultyArray = new ArrayList();

        try {
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT name FROM Faculty");
            ResultSet resultSet = getData(preparedStatement);

            while (resultSet.next()) {
                facultyArray.add(resultSet.getString(1));
            }
            // convert to a string array
            return (String[]) facultyArray.toArray(new String[facultyArray.size()]);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //method to get departments
    public String[] getDepartments(){
        List departmentArray = new ArrayList();

        try {
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT name FROM Department");
            ResultSet resultSet = getData(preparedStatement);

            while (resultSet.next()) {
                departmentArray.add(resultSet.getString(1));
            }
            // convert to a string array
            return (String[]) departmentArray.toArray(new String[departmentArray.size()]);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //method to get batches
    public String[] getBatches(){
        List batchArray = new ArrayList();

        try {
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT year FROM Batch");
            ResultSet resultSet = getData(preparedStatement);

            while (resultSet.next()) {
                batchArray.add(resultSet.getString(1));
            }
            // convert to a string array
            return (String[]) batchArray.toArray(new String[batchArray.size()]);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //add test
    //method to get a student using ID
    public static String[] getStudent(String ID){
        db = MysqlConnect.getMysqlConnect();

        List studentInfo = new ArrayList();

        try {
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT * FROM Student WHERE Student.ID = ?");
            preparedStatement.setString( 1, ID);
            resultSet = getData(preparedStatement);

            //adding the row values to the array
            int numberOfColumns = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                int i = 1;
                while(i <= numberOfColumns) {
                    studentInfo.add(resultSet.getString(i++));
                }
            }

            // convert to a string array
            return (String[]) studentInfo.toArray(new String[studentInfo.size()]);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //add test
    //method to add results to db
    public void setModuleGrades(ModuleGrade[] moduleGrades){
        try {
            for (ModuleGrade moduleGrade : moduleGrades){
                //test
                PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("INSERT INTO Student_has_Module VALUES(?,?,?,?)");
                preparedStatement.setString( 1, moduleGrade.getStudentID());
                preparedStatement.setString( 2, moduleGrade.getGrade());
                preparedStatement.setInt(3, moduleGrade.getSemesterId());
                preparedStatement.setString( 4, moduleGrade.getModuleCode());
                int result = setData(preparedStatement);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //test
    public static void setStudent(Student student){
        try {
            db = MysqlConnect.getMysqlConnect();
            
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("INSERT INTO Student VALUES(?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE CGPA=?,rank=?");
            preparedStatement.setString( 1, student.getID());
            preparedStatement.setString( 2, student.getName());
            preparedStatement.setDouble(3, student.getcGPA());
            preparedStatement.setInt( 4, student.getRank());
            preparedStatement.setString( 5, student.getUserId());
            preparedStatement.setInt( 6, student.getDepartment().getID());
            preparedStatement.setInt( 7, student.getBatch());
            preparedStatement.setDouble(8, student.getcGPA());
            preparedStatement.setInt( 9, student.getRank());
            int result = setData(preparedStatement);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //test
    public void setSemesterResults(SemesterResult semesterResult){
        try {
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("INSERT INTO Student_Semester_Results(Student_ID,Semester_ID,SGPA,rank,sem_credits) VALUES(?,?,?,?,?) ON DUPLICATE KEY UPDATE SGPA=?,rank=?,sem_credits=?");
            preparedStatement.setString(1, semesterResult.getStudentId());
            preparedStatement.setInt( 2, semesterResult.getSemesterId());
            preparedStatement.setDouble(3, semesterResult.getsGPA());
            preparedStatement.setInt(4, semesterResult.getsRank());
            preparedStatement.setDouble(5, semesterResult.getSemCredits());
            preparedStatement.setDouble(6, semesterResult.getsGPA());
            preparedStatement.setInt(7, semesterResult.getsRank());
            preparedStatement.setDouble(8, semesterResult.getSemCredits());
            
            int result = setData(preparedStatement);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //tested
    public static SemesterResult[] getSemesterResults(String faculty, String department, int batch, int semester){
        List semesterResults = new ArrayList();;
        try {           
            db = MysqlConnect.getMysqlConnect();
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT Student_ID,Semester_ID,SGPA,SMR.rank as srank,sem_credits FROM Student_Semester_Results SMR INNER JOIN Student S ON SMR.Student_ID=S.ID INNER JOIN Department D ON S.Department_ID=D.ID INNER JOIN Batch B ON S.Batch_ID=B.ID WHERE SMR.Semester_ID = ? AND D.name = ? AND B.year = ?");
            preparedStatement.setInt(1, semester);
            preparedStatement.setString(2, department);
            preparedStatement.setInt(3, batch);
            ResultSet resultSet = getData(preparedStatement);
            
            while (resultSet.next()) {
                SemesterResult semesterResult = new SemesterResult();
                semesterResult.setStudentId(resultSet.getString("Student_ID"));
                semesterResult.setSemesterId(resultSet.getInt("Semester_ID"));
                semesterResult.setsGPA(resultSet.getDouble("SGPA"));
                semesterResult.setsRank(resultSet.getInt("srank"));
                semesterResult.setSemCredits(resultSet.getDouble("sem_credits"));
                semesterResults.add(semesterResult);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        // convert to a SemesterResults array
        return (SemesterResult[]) semesterResults.toArray(new SemesterResult[semesterResults.size()]);
    }
    
    public static SemesterResult[] getSemesterResults(String faculty, String department, int batch){
        List semesterResults = new ArrayList();;
        try {           
            db = MysqlConnect.getMysqlConnect();
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT Student_ID,Semester_ID,SGPA,SSR.rank as srank,sem_credits FROM Student_Semester_Results SSR INNER JOIN Student S ON SSR.Student_ID=S.ID INNER JOIN Department D ON S.Department_ID=D.ID INNER JOIN Batch B ON S.Batch_ID=B.ID WHERE D.name = ? AND B.year = ?");
            preparedStatement.setString(1, department);
            preparedStatement.setInt(2, batch);
            ResultSet resultSet = getData(preparedStatement);
            
            while (resultSet.next()) {
                SemesterResult semesterResult = new SemesterResult();
                semesterResult.setStudentId(resultSet.getString("Student_ID"));
                semesterResult.setSemesterId(resultSet.getInt("Semester_ID"));
                semesterResult.setsGPA(resultSet.getDouble("SGPA"));
                semesterResult.setsRank(resultSet.getInt("srank"));
                semesterResult.setSemCredits(resultSet.getDouble("sem_credits"));
                semesterResults.add(semesterResult);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        // convert to a SemesterResults array
        return (SemesterResult[]) semesterResults.toArray(new SemesterResult[semesterResults.size()]);
    }
    
    //test
    //method to get sem results ordered  desc for ranking
    public static SemesterResult[] getSemesterResultsOrdered(String department, int batch, int semester){
        List semesterResults = new ArrayList();;
        try {           
            db = MysqlConnect.getMysqlConnect();
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT Student_ID,Semester_ID,SGPA,SMR.rank as srank,sem_credits FROM Student_Semester_Results SMR INNER JOIN Student S ON SMR.Student_ID=S.ID INNER JOIN Department D ON S.Department_ID=D.ID INNER JOIN Batch B ON S.Batch_ID=B.ID WHERE SMR.Semester_ID = ? AND D.name = ? AND B.year = ? ORDER BY SGPA DESC");
            preparedStatement.setInt(1, semester);
            preparedStatement.setString(2, department);
            preparedStatement.setInt(3, batch);
            ResultSet resultSet = getData(preparedStatement);
            
            while (resultSet.next()) {
                SemesterResult semesterResult = new SemesterResult();
                semesterResult.setStudentId(resultSet.getString("Student_ID"));
                semesterResult.setSemesterId(resultSet.getInt("Semester_ID"));
                semesterResult.setsGPA(resultSet.getDouble("SGPA"));
                semesterResult.setsRank(resultSet.getInt("srank"));
                semesterResult.setSemCredits(resultSet.getDouble("sem_credits"));
                semesterResults.add(semesterResult);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        // convert to a SemesterResults array
        return (SemesterResult[]) semesterResults.toArray(new SemesterResult[semesterResults.size()]);
    }
    
    //get from db
    //tested
    public static ModuleGrade[] getModuleGrades(String studentId) {
        List moduleGrades = new ArrayList();;
        try {           
            db = MysqlConnect.getMysqlConnect();
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT * FROM Student_has_Module WHERE Student_ID = ?");
            preparedStatement.setString(1, studentId);
            ResultSet resultSet = getData(preparedStatement);
            
            while (resultSet.next()) {
                ModuleGrade moduleGrade = new ModuleGrade(studentId, resultSet.getString("Module_code"), resultSet.getInt("Module_Semester_ID"), resultSet.getString("Grade_grade"));
                moduleGrades.add(moduleGrade);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        // convert to a SemesterResults array
        return (ModuleGrade[]) moduleGrades.toArray(new ModuleGrade[moduleGrades.size()]);
    }
    
    //tested
    public static Student[] getStudents(String faculty, String department, int batch) {
        List students = new ArrayList();;
        try {           
            db = MysqlConnect.getMysqlConnect();
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT S.ID as S_ID, S.name as S_name, CGPA, rank, User_ID, Department_ID, D.name as D_name, Faculty_ID, Batch_ID FROM Student S INNER JOIN Department D ON S.Department_ID=D.ID INNER JOIN Batch B ON S.Batch_ID=B.ID WHERE D.name = ? AND B.year = ?");
            preparedStatement.setString(1, department);
            preparedStatement.setInt(2, batch);
            ResultSet resultSet = getData(preparedStatement);
            
            while (resultSet.next()) {
                Student student = new Student();
                student.setID(resultSet.getString("S_ID"));
                student.setName(resultSet.getString("S_name"));
                student.setcGPA(resultSet.getDouble("CGPA"));
                student.setRank(resultSet.getInt("rank"));
                student.setUserId(resultSet.getString("User_ID"));
                student.setDepartment(new Department(resultSet.getInt("Department_ID"), resultSet.getString("D_name"), new Faculty(resultSet.getInt("Faculty_ID"), faculty)));
                student.setBatch(resultSet.getInt("Batch_ID"));
                students.add(student);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        // convert to a students array
        return (Student[]) students.toArray(new Student[students.size()]);
    }
    
    //test
    public static Student[] getStudentsOrdered(String faculty, String department, int batch) {
        List students = new ArrayList();;
        try {           
            db = MysqlConnect.getMysqlConnect();
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT S.ID as S_ID, S.name as S_name, CGPA, rank, User_ID, Department_ID, D.name as D_name, Faculty_ID, Batch_ID FROM Student S INNER JOIN Department D ON S.Department_ID=D.ID INNER JOIN Batch B ON S.Batch_ID=B.ID WHERE D.name = ? AND B.year = ? ORDER BY CGPA DESC");
            preparedStatement.setString(1, department);
            preparedStatement.setInt(2, batch);
            ResultSet resultSet = getData(preparedStatement);
            
            while (resultSet.next()) {
                Student student = new Student();
                student.setID(resultSet.getString("S_ID"));
                student.setName(resultSet.getString("S_name"));
                student.setcGPA(resultSet.getDouble("CGPA"));
                student.setRank(resultSet.getInt("rank"));
                student.setUserId(resultSet.getString("User_ID"));
                student.setDepartment(new Department(resultSet.getInt("Department_ID"), resultSet.getString("D_name"), new Faculty(resultSet.getInt("Faculty_ID"), faculty)));
                student.setBatch(resultSet.getInt("Batch_ID"));
                students.add(student);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        // convert to a students array
        return (Student[]) students.toArray(new Student[students.size()]);
    }
    
    //test
    public static Module[] getModules(int semester) {
        List modules = new ArrayList();;
        try {           
            db = MysqlConnect.getMysqlConnect();
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT * FROM Module INNER JOIN Semester ON Module.Semester_ID=Semester.ID WHERE Semester_ID = ?");
            preparedStatement.setInt(1, semester);
            ResultSet resultSet = getData(preparedStatement);
            
            while (resultSet.next()) {
                Module module = new Module(resultSet.getString("code"), resultSet.getString("title"), new Semester(resultSet.getInt("Semester_ID"), resultSet.getString("name")), resultSet.getDouble("credits"), resultSet.getBoolean("gpa"));
                modules.add(module);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        // convert to a students array
        return (Module[]) modules.toArray(new Module[modules.size()]);
    }
    
    
    //test
    public static Grade[] getGrades() {
        List grades = new ArrayList();;
        try {           
            db = MysqlConnect.getMysqlConnect();
            PreparedStatement preparedStatement = db.getDBConnection().prepareStatement("SELECT * FROM Grade");
            ResultSet resultSet = getData(preparedStatement);
            
            while (resultSet.next()) {
                Grade grade = new Grade(resultSet.getString("grade"), resultSet.getDouble("mark"));
                grades.add(grade);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        // convert to a students array
        return (Grade[]) grades.toArray(new Grade[grades.size()]);
    }
}
