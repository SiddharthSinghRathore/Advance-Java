/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marksmanagement.model;

/**
 *
 * @author mnpem
 */
public class User {
    private String id;
    private String password;
    private int userType;

    public User(String id) {
        this.id = id;
    }
    
    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public User(String id, String password, int userType) {
        this.id = id;
        this.password = password;
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
