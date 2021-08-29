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
import marksmanagement.model.Result;
import marksmanagement.model.Student;
/**
 *
 * @author mnpem
 */
public class StudentDAO {
    
    final private String jdbcURL = "jdbc:mysql://localhost:3306/marksmanagement";
    final private String jdbcUsername = "root";
    final private String jdbcPassword = "root";
    
     private static final String INSERT_STUDENT = "INSERT INTO STUDENTS" + "  (usn, fullName, semester, schemeYear, collegeEmail) VALUES " +
        " (?, ?, ?, ?, ?);";

    private static final String SELECT_STUDENT_BY_USN = "select * from STUDENTS where usn =?";
    private static final String SELECT_ALL_STUDENTS = "select * from STUDENTS";
    private static final String UPDATE_STUDENT = "update STUDENTS set fullName = ?, semester = ?, schemeYear = ?, collegeEmail= ? where usn = ?;";
    private static final String DELETE_STUDENT = "delete from STUDENTS where usn = ?;";
    private static final String GET_ALL_COURSES = "select * from COURSES where semester=? and schemeYear = ? and isElective=0";
    private static final String GET_ALL_ELECTIVES = "select STUDENTELECTIVES.electiveCode, COURSES.name, COURSES.isPractice from STUDENTELECTIVES"
            + " JOIN COURSES ON STUDENTELECTIVES.electiveCode=COURSES.code where usn=? and semester=?";
    private static final String GET_COURSE_TYPE = "Select isPractice from COURSES where code=?";
    private static final String GET_COURSE_SEMESTER = "Select semester from COURSES where code=?";
    private static final String GET_SCHEME_YEAR = "Select schemeYear from STUDENTS where usn=?";
    private static final String GET_STUDENT_SEMESTER = "Select semester from STUDENTS where usn=?";
    
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
    
    public boolean insertStudent(Student student) throws SQLException{
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(INSERT_STUDENT)){
            ps.setString(1, student.getUsn());
            ps.setString(2, student.getFullName());
            ps.setInt(3, student.getSemester());
            ps.setInt(4, student.getSchemeYear());
            ps.setString(5, student.getCollegeEmail());
            System.out.println(ps);
            ps.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public Student selectStudent(String inputUsn){
        Student student = null;
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_STUDENT_BY_USN);){
            ps.setString(1, inputUsn);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String usn = rs.getString("usn");
                String fullName = rs.getString("fullName");
                int semester = Integer.parseInt(rs.getString("semester"));
                int schemeYear = Integer.parseInt(rs.getString("schemeYear"));
                String collegeEmail = rs.getString("collegeEmail");
                student = new Student(usn, fullName, semester, schemeYear, collegeEmail);
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return student;
    }
    
    public List<Student> selectAllStudents(){
        List<Student> students = new ArrayList<>();
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_ALL_STUDENTS);){
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String usn = rs.getString("usn");
                String fullName = rs.getString("fullName");
                int semester = Integer.parseInt(rs.getString("semester"));
                int schemeYear = Integer.parseInt(rs.getString("schemeYear"));
                String collegeEmail = rs.getString("collegeEmail");
                students.add(new Student(usn, fullName, semester, schemeYear, collegeEmail));
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return students;
    }
    
    public boolean updateStudent(Student student) throws SQLException{
        boolean rowUpdated;
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(UPDATE_STUDENT);){
            ps.setString(1, student.getFullName());
            ps.setInt(2, student.getSemester());
            ps.setInt(3, student.getSchemeYear());
            ps.setString(4, student.getCollegeEmail());
            ps.setString(5, student.getUsn());
            
            rowUpdated = ps.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    public boolean deleteStudent(String usn) throws SQLException{
        boolean rowDeleted;
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(DELETE_STUDENT);) {
            ps.setString(1, usn);
            rowDeleted = ps.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    public Result selectCourseMarks(String inputCode, String inputUsn){
        final String SELECT_COURSE_MARKS_BY_USN = "SELECT grade from " + inputCode + " where usn=?";
        final String SELECT_COURSE_CREDITS = "SELECT credits from COURSES where code=?";
        Result result = null;
        int gradePoint = 5;
        char grade = 'F';
        int courseCredits = 4;
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_COURSE_MARKS_BY_USN);
                PreparedStatement ps2 = con.prepareStatement(SELECT_COURSE_MARKS_BY_USN);){
            ps.setString(1, inputUsn);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                grade = rs.getString("grade").charAt(0);
                switch(grade){
                    case 'S': gradePoint = 10;
                                break;
                    case 'A': gradePoint = 9;
                                break;
                    case 'B': gradePoint = 8;
                                break;
                    case 'C': gradePoint = 7;
                                break;
                    case 'D': gradePoint = 6;
                                break;
                    default: gradePoint = 0;        
                            break;
                } 
            }
            ps2.setString(1, inputCode);
            System.out.println(ps2);
            ResultSet rs2 = ps2.executeQuery();
            while(rs.next()){
                courseCredits = rs.getInt("credits");
            }
            result = new Result(inputCode, courseCredits, grade, gradePoint);
        } catch(SQLException e){
            System.out.println(e);
        }
        return result;
    }
    
    public List<Course> getAllCourses(int semester, String usn){
        List<Course> courses = getNonElectiveCourses(semester, usn);
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(GET_ALL_ELECTIVES);){
            ps.setString(1, usn);
            ps.setInt(2, semester);
            System.out.println(ps);
            ResultSet rs2 = ps.executeQuery();
            while(rs2.next()){
                String code = rs2.getString("electiveCode");
                String name = rs2.getString("name");
                boolean isPractice = rs2.getBoolean("isPractice");
                courses.add(new Course(code, name, isPractice));
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return courses;
    }
    
    public List<Course> getNonElectiveCourses(int semester, String usn){
        int schemeYear = getStudentSchemeYear(usn);
        List<Course> courses = new ArrayList<>();
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(GET_ALL_COURSES);){
            ps.setInt(1, semester);
            ps.setInt(2, schemeYear);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                boolean isPractice = rs.getBoolean("isPractice");
                courses.add(new Course(code, name, isPractice));
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return courses;
    }
    
    public void registerStudentToCourses(int semester, String usn) throws SQLException{
        List<Course> courses = getNonElectiveCourses(semester, usn);
        for (Course course : courses) {
            addStudentToCourse(course.getCode(), usn);
        }
    }
    
    public boolean addStudentToCourse(String code, String usn) throws SQLException{
        boolean isPractice = getCourseType(code);
        float testOne = -1, testTwo  = -1, testThree  = -1, testAverage  = -1, quizOne  = -1, quizTwo  = -1, assignment  = -1, 
            cieTotal  = -1, seeTotal  = -1, grandTotal  = -1, cie  = -1, labManual  = -1, labTest  = -1, labCie  = -1, theorySee  = -1, labSee  = -1;
        char grade = '-';
        boolean isBacklog = false;
        final String REGISTER_TO_PRACTICAL_COURSE = "INSERT INTO " + code + "  (usn, testOne, testTwo, testThree, testAverage, quizOne, quizTwo, assignment, cie, "
                + "labManual, labTest, labCie, cieTotal, theorySee, labSee, seeTotal, grandTotal, grade, isBacklog) VALUES " +
        " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        final String REGISTER_TO_THEORY_COURSE = "INSERT INTO " + code + "  (usn, testOne, testTwo, testThree, testAverage, quizOne, quizTwo, assignment, cieTotal, seeTotal, grandTotal, grade, isBacklog) VALUES " +
        " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try(Connection con = getConnection();
                PreparedStatement ps = isPractice ? con.prepareStatement(REGISTER_TO_PRACTICAL_COURSE) : con.prepareStatement(REGISTER_TO_THEORY_COURSE)){
            ps.setString(1, usn);
            ps.setFloat(2, testOne);
            ps.setFloat(3, testTwo);
            ps.setFloat(4, testThree);
            ps.setFloat(5, testAverage);
            ps.setFloat(6, quizOne);
            ps.setFloat(7, quizTwo);
            ps.setFloat(8, assignment);
            if(isPractice){
                ps.setFloat(9, cie);
                ps.setFloat(10, labManual);
                ps.setFloat(11, labTest);
                ps.setFloat(12, labCie);
                ps.setFloat(13, cieTotal);
                ps.setFloat(14, theorySee);
                ps.setFloat(15, labSee);
                ps.setFloat(16, seeTotal);
                ps.setFloat(17, grandTotal);
                ps.setString(18, String.valueOf(grade));
                ps.setBoolean(19, isBacklog);
            }
            else{
                ps.setFloat(9, cieTotal);
                ps.setFloat(10, seeTotal);
                ps.setFloat(11, grandTotal);
                ps.setString(12, String.valueOf(grade));
                ps.setBoolean(13, isBacklog);
            }
            System.out.println(ps);
            ps.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public boolean registerForCourse(String electiveCode, String usn) throws SQLException{ // For Electives
        int electiveSemester = getElectiveSemester(electiveCode);
        final String REGISTER_TO_ELECTIVE = "INSERT INTO STUDENTELECTIVES" + " (usn, electiveSemester, electiveCode) VALUES " + " (?, ?, ?)";
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(REGISTER_TO_ELECTIVE)){
            System.out.println(ps);
            ps.setString(1, usn);
            ps.setInt(2, electiveSemester);
            ps.setString(3, electiveCode);
            ps.executeUpdate();
            addStudentToCourse(electiveCode, usn);
        } catch(SQLException e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public boolean getCourseType(String inputCode){
        boolean isPractice = false;
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(GET_COURSE_TYPE);){
            ps.setString(1, inputCode);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                isPractice = rs.getBoolean("isPractice");
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return isPractice;
    }

    public int getElectiveSemester(String inputCode){
        int semester = 1;
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(GET_COURSE_SEMESTER);){
            ps.setString(1, inputCode);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                semester = rs.getInt("semester");
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return semester;
    }
    
    public List<Integer> getStudentSemesters(String inputUsn){
        List<Integer> semesters = new ArrayList<>();
        int semester = 1;
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(GET_STUDENT_SEMESTER);){
            ps.setString(1, inputUsn);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                semester = rs.getInt("semester");
            }
            while(semester > 0){
                semesters.add(semester);
                semester -= 1;
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return semesters;
    }
    
    public int getStudentSchemeYear(String inputUsn){
        int schemeYear = 2018;
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(GET_SCHEME_YEAR);){
            ps.setString(1, inputUsn);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                schemeYear = rs.getInt("schemeYear");
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return schemeYear;
    }
    
}
