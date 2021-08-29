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
public class Course {
    private String code;
    private String name;
    private int semester;
    private int schemeYear;
    private boolean isPractice;
    private boolean isElective;
    private String facultyOneId;
    private String facultyTwoId;
    private int credits;

    public Course(String code, String name, boolean isPractice) {
        this.code = code;
        this.name = name;
        this.isPractice = isPractice;
    }

    public Course(String code, String name, int semester, int schemeYear, boolean isPractice) {
        this.code = code;
        this.name = name;
        this.semester = semester;
        this.schemeYear = schemeYear;
        this.isPractice = isPractice;
    }

    public Course(String code, String name, int semester, int schemeYear, boolean isPractice, boolean isElective, String facultyOneId, String facultyTwoId, int credits) {
        this.code = code;
        this.name = name;
        this.semester = semester;
        this.schemeYear = schemeYear;
        this.isPractice = isPractice;
        this.isElective = isElective;
        this.facultyOneId = facultyOneId;
        this.facultyTwoId = facultyTwoId;
        this.credits = credits;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    public boolean isIsPractice() {
        return isPractice;
    }

    public void setIsPractice(boolean isPractice) {
        this.isPractice = isPractice;
    }
    
    public boolean isIsElective() {
        return isElective;
    }

    public void setIsElective(boolean isElective) {
        this.isElective = isElective;
    }
    
    public String getFacultyOneId() {
        return facultyOneId;
    }

    public void setFacultyOneId(String facultyOneId) {
        this.facultyOneId = facultyOneId;
    }

    public String getFacultyTwoId() {
        return facultyTwoId;
    }

    public void setFacultyTwoId(String facultyTwoId) {
        this.facultyTwoId = facultyTwoId;
    }
    
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

}
