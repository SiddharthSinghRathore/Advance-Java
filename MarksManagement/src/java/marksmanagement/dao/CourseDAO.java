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

/**
 *
 * @author mnpem
 */
public class CourseDAO {
    final private String jdbcURL = "jdbc:mysql://localhost:3306/marksmanagement";
    final private String jdbcUsername = "root";
    final private String jdbcPassword = "root";
    
    private static final String INSERT_COURSE = "INSERT INTO COURSES" + "  (code, name, semester, schemeYear, isPractice, isElective, facultyOneId, facultyTwoId, credits) VALUES " +
        " (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_COURSE_BY_CODE = "select * from COURSES where code =?";
    private static final String SELECT_ALL_COURSES = "select * from COURSES";
    private static final String UPDATE_COURSE = "update COURSES set name = ?, semester = ?, schemeYear= ?, isPractice= ?, isElective=?, facultyOneId = ?, facultyTwoId = ?, credits= ? where code = ?;";
    private static final String DELETE_COURSE = "delete from COURSES where code = ?;";
    
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
    
    public boolean insertCourse(Course course) throws SQLException{
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(INSERT_COURSE)){
            ps.setString(1, course.getCode());
            ps.setString(2, course.getName());
            ps.setInt(3, course.getSemester());
            ps.setInt(4, course.getSchemeYear());
            ps.setBoolean(5, course.isIsPractice());
            ps.setBoolean(6, course.isIsElective());
            ps.setString(7, course.getFacultyOneId());
            ps.setString(8, course.getFacultyTwoId());
            ps.setInt(9, course.getCredits());
            System.out.println(ps);
            ps.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public boolean createCourseTable(String code, boolean isPractical) throws SQLException{
        final String CREATE_PRACTICAL_COURSE_TABLE = "CREATE TABLE " + code + "(usn VARCHAR(10) PRIMARY KEY, testOne FLOAT, testTwo FLOAT, testThree FLOAT, testAverage FLOAT, quizOne FLOAT, "
            + "quizTwo FLOAT, assignment FLOAT, cie FLOAT, labManual FLOAT, labTest FLOAT, labCie FLOAT, cieTotal FLOAT, theorySee FLOAT, "
            + "labSee FLOAT, seeTotal FLOAT, grandTotal FLOAT, grade CHAR(1), isBacklog BOOLEAN, FOREIGN KEY(usn) REFERENCES STUDENTS(usn) ON DELETE CASCADE)";
        final String CREATE_THEORY_COURSE_TABLE = "CREATE TABLE " + code + "(usn VARCHAR(10) PRIMARY KEY, testOne FLOAT, testTwo FLOAT, testThree FLOAT, testAverage FLOAT, quizOne FLOAT, "
            + "quizTwo FLOAT, assignment FLOAT, cieTotal FLOAT, seeTotal FLOAT, grandTotal FLOAT, grade CHAR(1), isBacklog BOOLEAN, FOREIGN KEY(usn) REFERENCES STUDENTS(usn) ON DELETE CASCADE)";
        try(Connection con = getConnection();
                PreparedStatement ps = isPractical ? con.prepareStatement(CREATE_PRACTICAL_COURSE_TABLE) : con.prepareStatement(CREATE_THEORY_COURSE_TABLE)){
            System.out.println(ps);
            ps.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public Course selectCourse(String inputCode){
        Course course = null;
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_COURSE_BY_CODE);){
            ps.setString(1, inputCode);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                int semester = rs.getInt("semester");
                int schemeYear = rs.getInt("schemeYear");
                boolean isPractice = rs.getBoolean("isPractice");
                boolean isElective = rs.getBoolean("isElective");
                String facultyOneId = rs.getString("facultyOneId");
                String facultyTwoId = rs.getString("facultyTwoId");
                int credits = rs.getInt("credits");
                course = new Course(code, name, semester, schemeYear, isPractice, isElective, facultyOneId, facultyTwoId, credits);
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return course;
    }
    
    public List<Course> selectAllCourses(){
        List<Course> marks = new ArrayList<>();
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_ALL_COURSES);){
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                int semester = rs.getInt("semester");
                int schemeYear = rs.getInt("schemeYear");
                boolean isPractice = rs.getBoolean("isPractice");
                boolean isElective = rs.getBoolean("isElective");
                String facultyOneId = rs.getString("facultyOneId");
                String facultyTwoId = rs.getString("facultyTwoId");
                int credits = rs.getInt("credits");
                marks.add(new Course(code, name, semester, schemeYear, isPractice, isElective, facultyOneId, facultyTwoId, credits));
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return marks;
    }
    
    public boolean updateCourse(Course course) throws SQLException{
        boolean rowUpdated;
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(UPDATE_COURSE);){
            ps.setString(1, course.getName());
            ps.setInt(2, course.getSemester());
            ps.setInt(3, course.getSchemeYear());
            ps.setBoolean(4, course.isIsPractice());
            ps.setBoolean(5, course.isIsElective());
            ps.setString(6, course.getFacultyOneId());
            ps.setString(7, course.getFacultyTwoId());
            ps.setInt(8, course.getCredits());
            ps.setString(9, course.getCode());
            System.out.println(ps);
            rowUpdated = ps.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    public boolean deleteCourse(String code) throws SQLException{
        boolean rowDeleted;
        String DELETE_COURSE_TABLE = "DROP TABLE " + code;
        try(Connection con = getConnection();
         PreparedStatement ps = con.prepareStatement(DELETE_COURSE_TABLE);) {		      
         ps.executeUpdate();
         System.out.println(ps);   	  
      }
        try (Connection con = getConnection(); PreparedStatement ps2 = con.prepareStatement(DELETE_COURSE);) {
            ps2.setString(1, code);
            System.out.println(ps2); 
            rowDeleted = ps2.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
