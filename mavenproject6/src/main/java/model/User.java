/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author siddharthsinghrathour
 */
public class User 
{
	protected String usn;
	protected String name;
        protected String semester;
        
	protected String email;

    public User() {
    }

    public User(String usn, String name, String semester, String email) {
        this.usn = usn;
        this.name = name;
        this.semester = semester;
        this.email = email;
    }

    public User(String name, String semester, String email) {
        this.name = name;
        this.semester = semester;
        this.email = email;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
        
        
}
	
	
	