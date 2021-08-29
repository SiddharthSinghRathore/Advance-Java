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
import marksmanagement.model.Faculty;
/**
 *
 * @author mnpem
 */
public class FacultyDAO {
    
    final private String jdbcURL = "jdbc:mysql://localhost:3306/marksmanagement";
    final private String jdbcUsername = "root";
    final private String jdbcPassword = "root";
    
     private static final String INSERT_FACULTY = "INSERT INTO FACULTIES" + "  (id, designation, full_name, college_email) VALUES " +
        " (?, ?, ?, ?);";

    private static final String SELECT_FACULTY_BY_ID = "select * from FACULTIES where id =?";
    private static final String SELECT_ALL_FACULTIES = "select * from FACULTIES";
    private static final String UPDATE_FACULTY = "update FACULTIES set designation = ?, full_name = ?, college_email= ? where id = ?;";
    private static final String DELETE_FACULTY = "delete from FACULTIES where id = ?;";
    private static final String SELECT_COURSES_HANDLED = "select code, name, semester, schemeYear, isPractice from COURSES where facultyOneId= ? OR facultyTwoId= ?";
    
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
    
    public boolean insertFaculty(Faculty faculty) throws SQLException{
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(INSERT_FACULTY)){
            ps.setString(1, faculty.getId());
            ps.setString(2, faculty.getDesignation());
            ps.setString(3, faculty.getFullName());
            ps.setString(4, faculty.getCollegeEmail());
            System.out.println(ps);
            ps.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public Faculty selectFaculty(String inputId){
        Faculty faculty = null;
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_FACULTY_BY_ID);){
            ps.setString(1, inputId);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String id = rs.getString("id");
                String designation = rs.getString("designation");
                String fullName = rs.getString("full_name");
                String collegeEmail = rs.getString("college_email");
                faculty = new Faculty(id, designation, fullName, collegeEmail);
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return faculty;
    }
    
    public List<Faculty> selectAllFaculties(){
        List<Faculty> faculties = new ArrayList<>();
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_ALL_FACULTIES);){
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String id = rs.getString("id");
                String designation = rs.getString("designation");
                String fullName = rs.getString("full_name");
                String collegeEmail = rs.getString("college_email");
                faculties.add(new Faculty(id, designation, fullName, collegeEmail));
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return faculties;
    }
    
    public boolean updateFaculty(Faculty faculty) throws SQLException{
        boolean rowUpdated;
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(UPDATE_FACULTY);){
            ps.setString(1, faculty.getDesignation());
            ps.setString(2, faculty.getFullName());
            ps.setString(3, faculty.getCollegeEmail());
            ps.setString(4, faculty.getId());
            
            rowUpdated = ps.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    public boolean deleteFaculty(String id) throws SQLException{
        boolean rowDeleted;
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(DELETE_FACULTY);) {
            ps.setString(1, id);
            rowDeleted = ps.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    public List<Course> selectCoursesHandled(String id){
        List<Course> coursesHandled = new ArrayList<>();
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_COURSES_HANDLED);){
            ps.setString(1, id);
            ps.setString(2, id);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                int semester = Integer.parseInt(rs.getString("semester"));
                int schemeYear = Integer.parseInt(rs.getString("schemeYear"));
                boolean isPractice = rs.getBoolean("isPractice");
                coursesHandled.add(new Course(code, name, semester, schemeYear, isPractice));
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return coursesHandled;
    }
}
