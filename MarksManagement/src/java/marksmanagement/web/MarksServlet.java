/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marksmanagement.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import marksmanagement.dao.MarksDAO;
import marksmanagement.model.Marks;

/**
 *
 * @author mnpem
 */

public class MarksServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private MarksDAO marksDAO;
    private float testOne = -1, testTwo  = -1, testThree  = -1, testAverage  = -1, quizOne  = -1, quizTwo  = -1, assignment  = -1, 
            cieTotal  = -1, seeTotal  = -1, grandTotal  = -1, cie  = -1, labManual  = -1, labTest  = -1, labCie  = -1, theorySee  = -1, labSee  = -1;
    private char grade = '-';
    private boolean isBacklog = false;
    
    @Override
    public void init(){
        marksDAO = new MarksDAO();
    }
    
    public void printALL(){
        System.out.println(testOne);
        System.out.println(testOne);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FacultyServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FacultyServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String action = request.getServletPath();
        try {
            switch (action) {
                case "/newMarks":
                    showMarksForm(request, response);
                    break;
//                case "/insertMarks":
//                    insertMarks(request, response);
//                    break;
                case "/deleteMarks":
                    deleteMarks(request, response);
                    break;
                case "/editMarks":
                    showMarksEditForm(request, response);
                    break;
                case "/updateMarks":
                    updateMarks(request, response);
                    break;
                case "/listMarks":
                    listMarks(request, response);
                    break;
                case "/showStudentMarks":
                    showStudentMarks(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void listMarks(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        String code = request.getParameter("code");
        boolean isPractice = Boolean.parseBoolean(request.getParameter("isPractice"));
        List <Marks> listMarks = marksDAO.selectAllStudentsMarks(code, isPractice);
        request.setAttribute("code", code);
        request.setAttribute("isPractice", isPractice);
        request.setAttribute("listMarks", listMarks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("marks-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showMarksForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String code = request.getParameter("code");
        boolean isPractice = Boolean.parseBoolean(request.getParameter("isPractice"));
        request.setAttribute("code", code);
        request.setAttribute("isPractice", isPractice);
        RequestDispatcher dispatcher = request.getRequestDispatcher("marks-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showMarksEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        String code = request.getParameter("code");
        boolean isPractice = Boolean.parseBoolean(request.getParameter("isPractice"));
        String usn = request.getParameter("usn");
        Marks existingMarks = marksDAO.selectStudentMarks(code, isPractice, usn);
        RequestDispatcher dispatcher = request.getRequestDispatcher("marks-form.jsp");
        request.setAttribute("code", code);
        request.setAttribute("usn", usn);
        request.setAttribute("isPractice", isPractice);
        request.setAttribute("marks", existingMarks);
        dispatcher.forward(request, response);
    }
    
    private void showStudentMarks(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        String code = request.getParameter("code");
        boolean isPractice = Boolean.parseBoolean(request.getParameter("isPractice"));
        String usn = request.getParameter("usn");
        Marks existingMarks = marksDAO.selectStudentMarks(code, isPractice, usn);
        RequestDispatcher dispatcher = request.getRequestDispatcher("marks-table.jsp");
        request.setAttribute("isPractice", isPractice);
        request.setAttribute("marks", existingMarks);
        dispatcher.forward(request, response);
    }

//    private void insertMarks(HttpServletRequest request, HttpServletResponse response)
//    throws SQLException, IOException {
//        Marks marks;
//        String code = request.getParameter("code");
//        boolean isPractice = Boolean.parseBoolean(request.getParameter("isPractice"));
//        String usn = request.getParameter("usn");
//        testOne = Float.parseFloat(request.getParameter("testOne"));
//        testTwo = Float.parseFloat(request.getParameter("testTwo"));
//        testThree = Float.parseFloat(request.getParameter("testThree"));
//        testAverage = (testOne + testTwo + testThree) / 3;
//        quizOne = Float.parseFloat(request.getParameter("quizOne"));
//        quizTwo = Float.parseFloat(request.getParameter("quizTwo"));
//        assignment = Float.parseFloat(request.getParameter("assignment"));
//        if(isPractice){
//            cie = testAverage + quizOne + quizTwo + assignment;
//            labManual = Float.parseFloat(request.getParameter("labManual"));
//            labTest = Float.parseFloat(request.getParameter("labTest"));
//            labCie = labManual + (labTest / 5);
//            theorySee = Float.parseFloat(request.getParameter("theorySee"));
//            labSee = Float.parseFloat(request.getParameter("labSee"));
//            cieTotal = cieTotal = testAverage + quizOne + quizTwo + assignment + labCie;
//            seeTotal = theorySee + labSee;
//            grandTotal = cieTotal + seeTotal;
//            grade = calculateGrade(isPractice, Math.round((grandTotal * 100) / 300), cieTotal, theorySee, labSee, seeTotal);
//            marks = new Marks(usn, testOne, testTwo, testThree, testAverage, quizOne, quizTwo, assignment, cie, labManual, labTest, labCie, cieTotal, theorySee, labSee, seeTotal, grandTotal, grade);
//        }
//        else{
//            cieTotal = testAverage + quizOne + quizTwo + assignment;
//            seeTotal = Float.parseFloat(request.getParameter("theorySee"));
//            grandTotal = cieTotal + seeTotal;
//            grade = calculateGrade(isPractice, Math.round((grandTotal * 100) / 300), cieTotal, theorySee, labSee, seeTotal);
//            marks = new Marks(usn, testOne, testTwo, testThree, testAverage, quizOne, quizTwo, assignment, cieTotal, seeTotal, grandTotal, grade);
//        }
//        request.setAttribute("code", code);
//        request.setAttribute("isPractice", isPractice);
//        marksDAO.insertMarks(code, isPractice, marks);
//        response.sendRedirect("listMarks?code="+code+"&isPractice="+isPractice);
//    }

    private void updateMarks(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        Marks marks;
        String code = request.getParameter("code");
        boolean isPractice = Boolean.parseBoolean(request.getParameter("isPractice"));
        String usn = request.getParameter("usn");
        System.out.println(code);
        try{
            testOne = Float.parseFloat(request.getParameter("testOne"));
        }catch(java.lang.NumberFormatException e){
            testOne = -1;
        }
        try{
        testTwo = Float.parseFloat(request.getParameter("testTwo"));
        }catch(java.lang.NumberFormatException e){
            testTwo = -1;
        }
        try{
        testThree = Float.parseFloat(request.getParameter("testThree"));
                }catch(java.lang.NumberFormatException e){
            testThree = -1;
        }
        if(testOne != -1 && testTwo != -1 && testThree != -1){
        testAverage = (testOne + testTwo + testThree) / 3;
        }
        try{
        quizOne = Float.parseFloat(request.getParameter("quizOne"));
        }catch(java.lang.NumberFormatException e){
            quizOne = -1;
        }
        try{
        quizTwo = Float.parseFloat(request.getParameter("quizTwo"));
        }catch(java.lang.NumberFormatException e){
            quizTwo = -1;
        }
        try{
        assignment = Float.parseFloat(request.getParameter("assignment"));
        }catch(java.lang.NumberFormatException e){
            assignment = -1;
        }
        if(isPractice){
            if(testAverage != -1 && quizOne != -1 && quizTwo != -1 && assignment != -1){
            cie = testAverage + quizOne + quizTwo + assignment;
            }
            try{
            labManual = Float.parseFloat(request.getParameter("labManual"));
            }catch(java.lang.NumberFormatException e){
            labManual = -1;
        }
            try{
            labTest = Float.parseFloat(request.getParameter("labTest"));
            }catch(java.lang.NumberFormatException e){
            labTest = -1;
        }
            if(labManual != -1 && labTest != -1){
            labCie = ((labManual * 40) / 100) + (labTest / 5);
            }
            try{
            theorySee = Float.parseFloat(request.getParameter("theorySee"));
            }catch(java.lang.NumberFormatException e){
            theorySee = -1;
        }
            try{
            labSee = Float.parseFloat(request.getParameter("labSee"));
            }catch(java.lang.NumberFormatException e){
            labSee = -1;
        }
            if(cie != -1 && labCie != -1){
            cieTotal = cie + labCie;
            }
            if(theorySee != -1 && labSee != -1){
            seeTotal = theorySee + labSee;
            }
            if(cieTotal != -1 && seeTotal != -1){
            grandTotal = cieTotal + seeTotal;
            }
            if(testOne != -1 && testTwo != -1 && testThree != -1 && quizOne != -1 && quizTwo != -1 && assignment != - 1 && labManual != -1 && labTest != -1 && theorySee != -1 && labSee != -1){
            grade = calculateGrade(isPractice, Math.round((grandTotal * 100) / 300), cieTotal, theorySee, labSee, seeTotal);
            if(Character.compare(grade, 'F') == 0){
                isBacklog = true;
            }
            else{
                isBacklog = false;
            }
            }
            marks = new Marks(usn, testOne, testTwo, testThree, testAverage, quizOne, quizTwo, assignment, cie, labManual, labTest, labCie, cieTotal, theorySee, labSee, seeTotal, grandTotal, grade, isBacklog);
            
        }
        else{
            if(testAverage != -1 && quizOne != -1 && quizTwo != -1 && assignment != -1){
            cieTotal = testAverage + quizOne + quizTwo + assignment;
            }
            try{
            seeTotal = Float.parseFloat(request.getParameter("seeTotal"));
            }catch(java.lang.NumberFormatException e){
            seeTotal = -1;
        }
            if(cieTotal != -1 && seeTotal != -1){
            grandTotal = cieTotal + seeTotal;
            }
            if(testOne != -1 && testTwo != -1 && testThree != -1 && quizOne != -1 && quizTwo != -1 && assignment != - 1 && seeTotal != -1){
            grade = calculateGrade(isPractice, Math.round((grandTotal * 100) / 200), cieTotal, theorySee, labSee, seeTotal);
            if(Character.compare(grade, 'F') == 0){
                isBacklog = true;
            }
            else{
                isBacklog = false;
            }
            }
            marks = new Marks(usn, testOne, testTwo, testThree, testAverage, quizOne, quizTwo, assignment, cieTotal, seeTotal, grandTotal, grade, isBacklog);
            
        }
        marksDAO.updateMarks(code, isPractice, marks);
        response.sendRedirect("listMarks?code="+code+"&isPractice="+isPractice);
    }

    private void deleteMarks(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String code = request.getParameter("code");
        boolean isPractice = Boolean.parseBoolean(request.getParameter("isPractice"));
        String usn = request.getParameter("usn");
        marksDAO.deleteStudentMarks(code, usn);
        response.sendRedirect("listMarks?code="+code+"&isPractice="+isPractice);
    }
    
    private char calculateGrade(boolean isPractice, float grandTotalOutOfHundred, float cieTotal, float theorySee, float labSee, float seeTotal){
        if(isPractice){
            if(cieTotal < 75 || theorySee < 40 || labSee < 25 || seeTotal < 75){
                return 'F';
            }
        }
        else{
            if(cieTotal < 50 || seeTotal < 40){
                return 'F';
            }
        }
        if(grandTotalOutOfHundred >=90){
            return 'S';
        }
        else if(grandTotalOutOfHundred >= 80){
            return 'A';
        }
        else if(grandTotalOutOfHundred >= 70){
            return 'B';
        }
        else if(grandTotalOutOfHundred >= 60){
            return 'C';
        }
        else if(grandTotalOutOfHundred >= 50){
            return 'D';
        }
        else{
            return 'F';
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
