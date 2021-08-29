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
public class Student {
    private String usn;
    private String fullName;
    private int semester;
    private int schemeYear;
    private String collegeEmail;

    public Student(String usn, String fullName, int semester, int schemeYear, String collegeEmail) {
        this.usn = usn;
        this.fullName = fullName;
        this.semester = semester;
        this.schemeYear = schemeYear;
        this.collegeEmail = collegeEmail;
    }


    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    public int getSchemeYear() {
        return schemeYear;
    }

    public void setSchemeYear(int schemeYear) {
        this.schemeYear = schemeYear;
    }

    public String getCollegeEmail() {
        return collegeEmail;
    }

    public void setCollegeEmail(String collegeEmail) {
        this.collegeEmail = collegeEmail;
    }
}
