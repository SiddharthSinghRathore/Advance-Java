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
public class Faculty {
    private String id;
    private String designation;
    private String fullName;
    private String collegeEmail;

    public Faculty() {
    }

    public Faculty(String id, String designation, String fullName, String collegeEmail) {
        this.id = id;
        this.designation = designation;
        this.fullName = fullName;
        this.collegeEmail = collegeEmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCollegeEmail() {
        return collegeEmail;
    }

    public void setCollegeEmail(String collegeEmail) {
        this.collegeEmail = collegeEmail;
    }
}
