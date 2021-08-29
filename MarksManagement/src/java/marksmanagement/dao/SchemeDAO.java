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
import marksmanagement.model.Scheme;

/**
 *
 * @author mnpem
 */
public class SchemeDAO {
    
    final private String jdbcURL = "jdbc:mysql://localhost:3306/marksmanagement";
    final private String jdbcUsername = "root";
    final private String jdbcPassword = "root";
    
     private static final String INSERT_SCHEME = "INSERT INTO SCHEMES" + "  (schemeYear) VALUES " +
        " (?);";

    private static final String SELECT_SCHEME_BY_YEAR = "select * from SCHEMES where schemeYear =?";
    private static final String SELECT_ALL_SCHEMES = "select * from SCHEMES";
    private static final String DELETE_SCHEME = "delete from SCHEMES where schemeYear = ?;";
    
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
    
    public boolean insertScheme(Scheme scheme) throws SQLException{
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(INSERT_SCHEME)){
            ps.setInt(1, scheme.getSchemeYear());
            System.out.println(ps);
            ps.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
            return false;
        }
//        final String CREATE_SCHEME_RESULTS_TABLE = "CREATE table " + scheme.getSchemeYear() + "(usn VARCHAR(10) PRIMARY KEY, FOREIGN KEY(usn) REFERENCES STUDENTS(usn) ON DELETE CASCADE);";
//        try(Connection con = getConnection();
//                PreparedStatement ps = con.prepareStatement(CREATE_SCHEME_RESULTS_TABLE);){
//            System.out.println(ps);
//            ps.executeUpdate();
//        } catch(SQLException e){
//            System.out.println(e);
//            return false;
//        }
//        for(int i = 1; i <= scheme.getNumberOfSubjectsPerSemester(); i++){
//            String ADD_SUBJECT_SCORE_FOR_SCHEME = "ALTER table " + scheme.getSchemeYear() + "ADD subject" + i + "Score FLOAT";   
//            try(Connection con = getConnection();
//                PreparedStatement ps = con.prepareStatement(ADD_SUBJECT_SCORE_FOR_SCHEME);){
//                System.out.println(ps);
//                ps.executeUpdate();
//        } catch(SQLException e){
//            System.out.println(e);
//            return false;
//        }
//        final String ADD_CGPA_FOR_SCHEME = "ALTER table " + scheme.getSchemeYear() + "ADD CGPA FLOAT";    
//                    try(Connection con = getConnection();
//                PreparedStatement ps = con.prepareStatement(ADD_CGPA_FOR_SCHEME);){
//                System.out.println(ps);
//                ps.executeUpdate();
//        } catch(SQLException e){
//            System.out.println(e);
//            return false;
//        }
//        }
        return true;
    }

    
    public List<Scheme> selectAllSchemes(){
        List<Scheme> scheme = new ArrayList<>();
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_ALL_SCHEMES);){
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int schemeYear = rs.getInt("schemeYear");
                scheme.add(new Scheme(schemeYear));
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return scheme;
    }
    
    public boolean deleteScheme(int schemeYear) throws SQLException{
        final String DELETE_SCHEME_RESULTS_TABLE = "DELETE FROM SCHEMES where schemeYear=" + schemeYear;
        boolean rowDeleted;
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(DELETE_SCHEME);
                PreparedStatement ps2 = con.prepareStatement(DELETE_SCHEME_RESULTS_TABLE);) {
            ps.setInt(1, schemeYear);
            ps2.executeUpdate();
            rowDeleted = ps.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
}

