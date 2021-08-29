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
public class Marks {
    private String usn;
    private float testOne, testTwo, testThree, testAverage, quizOne, quizTwo;
    private float assignment, cie, labManual, labTest, labCie, cieTotal;
    private float theorySee, labSee, seeTotal, grandTotal;
    private char grade;
    private boolean isBacklog;

    public Marks(String usn, float testOne, float testTwo, float testThree, float testAverage, float quizOne, float quizTwo, float assignment, float cieTotal, float seeTotal, float grandTotal, char grade, boolean isBacklog) {
        this.usn = usn;
        this.testOne = testOne;
        this.testTwo = testTwo;
        this.testThree = testThree;
        this.testAverage = testAverage;
        this.quizOne = quizOne;
        this.quizTwo = quizTwo;
        this.assignment = assignment;
        this.cieTotal = cieTotal;
        this.seeTotal = seeTotal;
        this.grandTotal = grandTotal;
        this.grade = grade;
        this.isBacklog = isBacklog;
    }

    public Marks(String usn, float testOne, float testTwo, float testThree, float testAverage, float quizOne, float quizTwo, float assignment, float cie, float labManual, float labTest, float labCie, float cieTotal, float theorySee, float labSee, float seeTotal, float grandTotal, char grade, boolean isBacklog) {
        this.usn = usn;
        this.testOne = testOne;
        this.testTwo = testTwo;
        this.testThree = testThree;
        this.testAverage = testAverage;
        this.quizOne = quizOne;
        this.quizTwo = quizTwo;
        this.assignment = assignment;
        this.cie = cie;
        this.labManual = labManual;
        this.labTest = labTest;
        this.labCie = labCie;
        this.cieTotal = cieTotal;
        this.theorySee = theorySee;
        this.labSee = labSee;
        this.seeTotal = seeTotal;
        this.grandTotal = grandTotal;
        this.grade = grade;
        this.isBacklog = isBacklog;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public float getTestOne() {
        return testOne;
    }

    public void setTestOne(float testOne) {
        this.testOne = testOne;
    }

    public float getTestTwo() {
        return testTwo;
    }

    public void setTestTwo(float testTwo) {
        this.testTwo = testTwo;
    }

    public float getTestThree() {
        return testThree;
    }

    public void setTestThree(float testThree) {
        this.testThree = testThree;
    }

    public float getTestAverage() {
        return testAverage;
    }

    public void setTestAverage(float testAverage) {
        this.testAverage = testAverage;
    }

    public float getQuizOne() {
        return quizOne;
    }

    public void setQuizOne(float quizOne) {
        this.quizOne = quizOne;
    }

    public float getQuizTwo() {
        return quizTwo;
    }

    public void setQuizTwo(float quizTwo) {
        this.quizTwo = quizTwo;
    }

    public float getAssignment() {
        return assignment;
    }

    public void setAssignment(float assignment) {
        this.assignment = assignment;
    }

    public float getCie() {
        return cie;
    }

    public void setCie(float cie) {
        this.cie = cie;
    }

    public float getLabManual() {
        return labManual;
    }

    public void setLabManual(float labManual) {
        this.labManual = labManual;
    }

    public float getLabTest() {
        return labTest;
    }

    public void setLabTest(float labTest) {
        this.labTest = labTest;
    }

    public float getLabCie() {
        return labCie;
    }

    public void setLabCie(float labCie) {
        this.labCie = labCie;
    }

    public float getCieTotal() {
        return cieTotal;
    }

    public void setCieTotal(float cieTotal) {
        this.cieTotal = cieTotal;
    }

    public float getTheorySee() {
        return theorySee;
    }

    public void setTheorySee(float theorySee) {
        this.theorySee = theorySee;
    }
    
    public float getLabSee() {
        return labSee;
    }

    public void setLabSee(float labSee) {
        this.labSee = labSee;
    }

    public float getSeeTotal() {
        return seeTotal;
    }

    public void setSeeTotal(float seeTotal) {
        this.seeTotal = seeTotal;
    }

    public float getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(float grandTotal) {
        this.grandTotal = grandTotal;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
    
    public boolean isIsBacklog() {
        return isBacklog;
    }

    public void setIsBacklog(boolean isBacklog) {
        this.isBacklog = isBacklog;
    }
    
}
