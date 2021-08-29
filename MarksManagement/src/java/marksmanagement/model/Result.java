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
public class Result {
    private String courseCode;
    private int courseCredits;
    private char grade;
    private int gradePoint;

    public Result(String courseCode, int courseCredits, char grade, int gradePoint) {
        this.courseCode = courseCode;
        this.courseCredits = courseCredits;
        this.grade = grade;
        this.gradePoint = gradePoint;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    
    public int getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public int getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(int gradePoint) {
        this.gradePoint = gradePoint;
    }
}
