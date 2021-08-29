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
import marksmanagement.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author mnpem
 */
public class UserDAO {
    final private String jdbcURL = "jdbc:mysql://localhost:3306/marksmanagement";
    final private String jdbcUsername = "root";
    final private String jdbcPassword = "root";
    
     private static final String INSERT_USER = "INSERT INTO USERS" + "  (id, password, userType) VALUES " +
        " (?, ?, ?);";
     private static final String AUTHENTICATE_USER = "select * from USERS where id = ?;";
     private static final String CHANGE_PASSWORD = "update USERS set password = ? where id = ?;";
     private static final String DELETE_USER = "delete from USERS where id = ?;";
     private static final String GET_OLD_PASSWORD = "select password from USERS where id = ?;";
     private static final BCryptPasswordEncoder B_CRYPT_PASSWORD_ENCODER = new BCryptPasswordEncoder();

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
    
    public boolean insertUser(User user, String userTypeInput) throws SQLException{
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(INSERT_USER)){
            ps.setString(1, user.getId());
            String password = "rvce";
            String bCryptedPassword = B_CRYPT_PASSWORD_ENCODER.encode(password);
            //boolean passwordIsValid = bCryptPasswordEncoder.matches("password", bCryptedPassword);
            ps.setString(2, bCryptedPassword); // default password = rvce
            if(userTypeInput.equals("faculty")){
                ps.setInt(3, 1);
            }
            else if(userTypeInput.equals("student")){
                ps.setInt(3, 2);
            }
            else{
                ps.setInt(3, 0); // admin
            }
            System.out.println(ps);
            ps.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public int authenticateUser(User user) throws SQLException{
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(AUTHENTICATE_USER);){
            ps.setString(1, user.getId());
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String password = rs.getString("password");
                int userType = rs.getInt("userType");
                if(B_CRYPT_PASSWORD_ENCODER.matches(user.getPassword(), password)){
                    switch (userType) {
                        case 0:
                            return 0;
                        case 1:
                            return 1;
                        default:
                            return 2;
                    }
                }
                else{
                    return -1;
                }
            }
        } catch(SQLException e){
            System.out.println(e);
            return -1;
        }
        return -1;
    }
    
    public boolean deleteUser(String id) throws SQLException{
        boolean rowDeleted;
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(DELETE_USER);) {
            ps.setString(1, id);
            rowDeleted = ps.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    public String getOldPassword(String id) throws SQLException{
        String password = null;
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(GET_OLD_PASSWORD);){
            ps.setString(1, id);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                password = rs.getString("password");
            }
        } catch(SQLException e){
            System.out.println(e);
            return password;
        }
        return password;
    }
    
    public boolean changePassword(String id, String newPassword) throws SQLException{
        boolean rowUpdated;
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(CHANGE_PASSWORD);){
            String bCryptedPassword = B_CRYPT_PASSWORD_ENCODER.encode(newPassword);
            ps.setString(1, bCryptedPassword);
            ps.setString(2, id);
            rowUpdated = ps.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
