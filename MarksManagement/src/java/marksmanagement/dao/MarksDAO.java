/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marksmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import marksmanagement.model.Course;
import marksmanagement.model.Marks;

/**
 *
 * @author mnpem
 */
public class MarksDAO {
    final private String jdbcURL = "jdbc:mysql://localhost:3306/marksmanagement";
    final private String jdbcUsername = "root";
    final private String jdbcPassword = "root";
    
    
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    
//    public boolean insertMarks(String code, boolean isPractice, Marks marks) throws SQLException{
//        final String INSERT_PRACTICAL_COURSE_MARKS = "INSERT INTO " + code + "(usn, testOne, testTwo, testThree, testAverage, quizOne, "
//                + "quizTwo, assignment, cie, labManual, labTest, labCie, cieTotal, theorySee, labSee, seeTotal, grandTotal, grade) VALUES " +
//        " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
//        final String INSERT_THEORY_COURSE_MARKS = "INSERT INTO " + code + "(usn, testOne, testTwo, testThree, testAverage, quizOne, "
//                + "quizTwo, assignment, cieTotal, seeTotal, grandTotal, grade) VALUES " +
//        " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
//        try(Connection con = getConnection();
//                PreparedStatement ps = isPractice ? con.prepareStatement(INSERT_PRACTICAL_COURSE_MARKS) : con.prepareStatement(INSERT_THEORY_COURSE_MARKS)){
//            ps.setString(1, marks.getUsn());
//            ps.setFloat(2, marks.getTestOne());
//            ps.setFloat(3, marks.getTestTwo());
//            ps.setFloat(4, marks.getTestThree());
//            ps.setFloat(5, marks.getTestAverage());
//            ps.setFloat(6, marks.getQuizOne());
//            ps.setFloat(7, marks.getQuizTwo());
//            ps.setFloat(8, marks.getAssignment());
//            if(isPractice){
//                ps.setFloat(9, marks.getCie());
//                ps.setFloat(10, marks.getLabManual());
//                ps.setFloat(11, marks.getLabTest());
//                ps.setFloat(12, marks.getLabCie());
//                ps.setFloat(13, marks.getCieTotal());
//                ps.setFloat(14, marks.getTheorySee());
//                ps.setFloat(15, marks.getLabSee());
//                ps.setFloat(16, marks.getSeeTotal());
//                ps.setFloat(17, marks.getGrandTotal());
//                ps.setString(18, String.valueOf(marks.getGrade()));
//            }
//            else{
//                ps.setFloat(9, marks.getCieTotal());
//                ps.setFloat(10, marks.getSeeTotal());
//                ps.setFloat(11, marks.getGrandTotal());
//                ps.setString(12, String.valueOf(marks.getGrade()));
//            }
//            System.out.println(ps);
//            ps.executeUpdate();
//        } catch(SQLException e){
//            System.out.println(e);
//            return false;
//        }
//        return true;
//    }
    
    public Marks selectStudentMarks(String code, boolean isPractice, String inputUsn){
        final String SELECT_MARKS_BY_USN = "select * from "+ code +" where usn =?";
        Marks marks = null;
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_MARKS_BY_USN);){
            ps.setString(1, inputUsn);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String usn = rs.getString("usn");
                float testOne = Float.parseFloat(rs.getString("testOne"));
                float testTwo = Float.parseFloat(rs.getString("testTwo"));
                float testThree = Float.parseFloat(rs.getString("testThree"));
                float testAverage = Float.parseFloat(rs.getString("testAverage"));
                float quizOne = Float.parseFloat(rs.getString("quizOne"));
                float quizTwo = Float.parseFloat(rs.getString("quizTwo"));
                float assignment = Float.parseFloat(rs.getString("assignment"));
                float cieTotal = Float.parseFloat(rs.getString("cieTotal"));
                float seeTotal = -1;//Float.parseFloat(rs.getString("seeTotal"));
                float grandTotal = -1;//Float.parseFloat(rs.getString("grandTotal"));
                char grade = rs.getString("grade").charAt(0);
                boolean isBacklog = rs.getBoolean("isBacklog");
                if(isPractice){
                    float cie = Float.parseFloat(rs.getString("cie"));
                    float labManual = Float.parseFloat(rs.getString("labManual"));
                    float labTest = Float.parseFloat(rs.getString("labTest"));
                    float labCie = Float.parseFloat(rs.getString("labCie")); 
                    float theorySee = -1;//Float.parseFloat(rs.getString("theorySee"));
                    float labSee = -1;//Float.parseFloat(rs.getString("labSee"));
                    marks = new Marks(usn, testOne, testTwo, testThree, testAverage, quizOne, quizTwo, assignment, cie, labManual, labTest, labCie, cieTotal, theorySee, labSee, seeTotal, grandTotal, grade, isBacklog);
                }
                else{
                    marks = new Marks(usn, testOne, testTwo, testThree, testAverage, quizOne, quizTwo, assignment, cieTotal, seeTotal, grandTotal, grade, isBacklog);
                }
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return marks;
    }
    
    public List<Marks> selectAllStudentsMarks(String code, boolean isPractice){
        final String SELECT_ALL_STUDENTS_MARKS = "select * from "+ code;
                
        List<Marks> marks = new ArrayList<>();
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_ALL_STUDENTS_MARKS);){
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String usn = rs.getString("usn");
                float testOne = Float.parseFloat(rs.getString("testOne"));
                float testTwo = Float.parseFloat(rs.getString("testTwo"));
                float testThree = Float.parseFloat(rs.getString("testThree"));
                float testAverage = Float.parseFloat(rs.getString("testAverage"));
                float quizOne = Float.parseFloat(rs.getString("quizOne"));
                float quizTwo = Float.parseFloat(rs.getString("quizTwo"));
                float assignment = Float.parseFloat(rs.getString("assignment"));
                float cieTotal = Float.parseFloat(rs.getString("cieTotal"));
                float seeTotal = Float.parseFloat(rs.getString("seeTotal"));
                float grandTotal = Float.parseFloat(rs.getString("grandTotal"));
                char grade = rs.getString("grade").charAt(0);
                boolean isBacklog = rs.getBoolean("isBacklog");
                if(isPractice){
                    float cie = Float.parseFloat(rs.getString("cie"));
                    float labManual = Float.parseFloat(rs.getString("labManual"));
                    float labTest = Float.parseFloat(rs.getString("labTest"));
                    float labCie = Float.parseFloat(rs.getString("labCie")); 
                    float theorySee = Float.parseFloat(rs.getString("theorySee"));
                    float labSee = Float.parseFloat(rs.getString("labSee"));
                    marks.add(new Marks(usn, testOne, testTwo, testThree, testAverage, quizOne, quizTwo, assignment, cie, labManual, labTest, labCie, cieTotal, theorySee, labSee, seeTotal, grandTotal, grade, isBacklog));
                }
                else{
                    marks.add(new Marks(usn, testOne, testTwo, testThree, testAverage, quizOne, quizTwo, assignment, cieTotal, seeTotal, grandTotal, grade, isBacklog));
                }
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return marks;
    }
    
    public boolean updateMarks(String code, boolean isPractice, Marks marks) throws SQLException{
        final String UPDATE_PRACTICAL_COURSE_MARKS = "update " + code + " set testOne= ?, testTwo= ?, testThree= ?, testAverage= ?, quizOne= ?, "
                + " quizTwo= ?, assignment= ?, cie= ?, labManual= ?, labTest= ?, labCie= ?, cieTotal= ?, theorySee= ?, labSee= ?, seeTotal= ?, grandTotal= ?, grade= ?, isBacklog= ? where usn = ?;";
        final String UPDATE_THEORY_COURSE_MARKS = "update " + code + " set testOne= ?, testTwo= ?, testThree= ?, testAverage= ?, quizOne= ?, "
                + " quizTwo= ?, assignment= ?, cieTotal= ?, seeTotal= ?, grandTotal= ?, grade= ?, isBacklog= ? where usn = ?;";
        boolean rowUpdated;
        try(Connection con = getConnection();
                PreparedStatement ps = isPractice ? con.prepareStatement(UPDATE_PRACTICAL_COURSE_MARKS) : con.prepareStatement(UPDATE_THEORY_COURSE_MARKS)){
            ps.setFloat(1, marks.getTestOne());
            ps.setFloat(2, marks.getTestTwo());
            ps.setFloat(3, marks.getTestThree());
            ps.setFloat(4, marks.getTestAverage());
            ps.setFloat(5, marks.getQuizOne());
            ps.setFloat(6, marks.getQuizTwo());
            ps.setFloat(7, marks.getAssignment());
            if(isPractice){
                ps.setFloat(8, marks.getCie());
                ps.setFloat(9, marks.getLabManual());
                ps.setFloat(10, marks.getLabTest());
                ps.setFloat(11, marks.getLabCie());
                ps.setFloat(12, marks.getCieTotal());
                ps.setFloat(13, marks.getTheorySee());
                ps.setFloat(14, marks.getLabSee());
                ps.setFloat(15, marks.getSeeTotal());
                ps.setFloat(16, marks.getGrandTotal());
                ps.setString(17, String.valueOf(marks.getGrade()));
                ps.setBoolean(18, marks.isIsBacklog());
                ps.setString(19, marks.getUsn());
            }
            else{
                ps.setFloat(8, marks.getCieTotal());
                ps.setFloat(9, marks.getSeeTotal());
                ps.setFloat(10, marks.getGrandTotal());
                ps.setString(11, String.valueOf(marks.getGrade()));
                ps.setBoolean(12, marks.isIsBacklog());
                ps.setString(13, marks.getUsn());
            }
            System.out.println(ps);
            
            rowUpdated = ps.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    public boolean deleteStudentMarks(String code, String usn) throws SQLException{
        final String DELETE_MARKS = "delete from " + code + " where usn= ?;";
        boolean rowDeleted;
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(DELETE_MARKS);) {
            ps.setString(1, usn);
            System.out.println(ps);
            rowDeleted = ps.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    public List<Course> selectSingleStudentCourses(String inputUsn, int inputSemester) throws SQLException{
        StudentDAO studentDAO = new StudentDAO();
//        final String FETCH_STUDENT_SEMESTER = "select semester from STUDENTS where usn =?";
//        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(FETCH_STUDENT_SEMESTER);) {
//            ps.setString(1, inputUsn);
//            System.out.println(ps);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                semester = rs.getInt("semester");
//        }
        List<Course> courses = studentDAO.getAllCourses(inputSemester, inputUsn);
        return courses;
        //}
    }
    
}
