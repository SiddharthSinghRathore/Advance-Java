/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marksmanagement.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import marksmanagement.dao.MarksDAO;
import marksmanagement.dao.SchemeDAO;
import marksmanagement.dao.StudentDAO;
import marksmanagement.dao.UserDAO;
import marksmanagement.model.Course;
import marksmanagement.model.Marks;
import marksmanagement.model.Result;
import marksmanagement.model.Scheme;
import marksmanagement.model.Student;
import marksmanagement.model.User;

/**
 *
 * @author mnpem
 */

public class StudentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private StudentDAO studentDAO;
    private UserDAO userDAO;
    private MarksDAO marksDAO;
    private SchemeDAO schemeDAO;
    final private String userType = "student";
    private final float testOne = -1, testTwo  = -1, testThree  = -1, testAverage  = -1, quizOne  = -1, quizTwo  = -1, assignment  = -1, 
            cieTotal  = -1, seeTotal  = -1, grandTotal  = -1, cie  = -1, labManual  = -1, labTest  = -1, labCie  = -1, theorySee  = -1, labSee  = -1;
    
    @Override
    public void init(){
        studentDAO = new StudentDAO();
        userDAO = new UserDAO();
        marksDAO = new MarksDAO();
        schemeDAO = new SchemeDAO();
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
                case "/newStudent":
                    showStudentForm(request, response);
                    break;
                case "/insertStudent":
                    insertStudent(request, response);
                    break;
                case "/deleteStudent":
                    deleteStudent(request, response);
                    break;
                case "/editStudent":
                    showStudentEditForm(request, response);
                    break;
                case "/updateStudent":
                    updateStudent(request, response);
                    break;
                case "/listStudents":
                    listStudents(request, response);
                    break;
                case "/listStudentCourses":
                    listStudentCourses(request, response);
                    break;
                case "/registerForACourse":
                    registerToCourse(request, response);
                    break;
                case "/registerForACourseForm":
                    showRegisterForACourseForm(request, response);
                    break;
                case "/studentSemesters":
                    showStudentSemesters(request, response);
                    break;
                case "/studentResult":
                    studentSGPA(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void listStudents(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List <Student> listStudents = studentDAO.selectAllStudents();
        request.setAttribute("listStudent", listStudents);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showStudentForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        List<Scheme> schemeYears = schemeDAO.selectAllSchemes();
        request.setAttribute("schemeYears", schemeYears);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showRegisterForACourseForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String usn = request.getParameter("usn");
        int semester = Integer.parseInt(request.getParameter("semester"));
        request.setAttribute("usn", usn);
        request.setAttribute("semester", semester);
        RequestDispatcher dispatcher = request.getRequestDispatcher("register-for-a-course.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showStudentEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        List<Scheme> schemeYears = schemeDAO.selectAllSchemes();
        request.setAttribute("schemeYears", schemeYears);
        String usn = request.getParameter("usn");
        Student existingStudent = studentDAO.selectStudent(usn);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        request.setAttribute("student", existingStudent);
        dispatcher.forward(request, response);
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        //Marks marks = null;
        String usn = request.getParameter("usn");
        String fullName = request.getParameter("fullName");
        int semester =  Integer.parseInt(request.getParameter("semester"));
        int schemeYear =  Integer.parseInt(request.getParameter("schemeYear"));
        String collegeEmail = request.getParameter("collegeEmail");
        Student newStudent = new Student(usn, fullName, semester, schemeYear, collegeEmail);
        studentDAO.insertStudent(newStudent);
        studentDAO.registerStudentToCourses(semester, usn);
        User user = new User(usn);
        userDAO.insertUser(user, userType);
//        List<Course> courses = studentDAO.getAllCourses(semester);
//        for(int i = 0; i < courses.size(); i++){
//            if(courses.get(i).isIsPractice()){
//                marks = new Marks(usn, testOne, testTwo, testThree, testAverage, quizOne, quizTwo, assignment, cie, labManual, labTest, labCie, cieTotal, theorySee, labSee, seeTotal, grandTotal, '-');
//                marksDAO.insertMarks(courses.get(i).getCode(), courses.get(i).isIsPractice(), marks);
//            }
//            else{
//                marks = new Marks(usn, testOne, testTwo, testThree, testAverage, quizOne, quizTwo, assignment,cieTotal, seeTotal, grandTotal, '-');
//                marksDAO.insertMarks(courses.get(i).getCode(), courses.get(i).isIsPractice(), marks);
//            }
//        }
        response.sendRedirect("listStudents");
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        //Marks marks = null;
        String usn = request.getParameter("usn");
        String fullName = request.getParameter("fullName");
        int semester =  Integer.parseInt(request.getParameter("semester"));
        int schemeYear =  Integer.parseInt(request.getParameter("schemeYear"));
        String collegeEmail = request.getParameter("collegeEmail");
        Student student = new Student(usn, fullName, semester, schemeYear, collegeEmail);
        studentDAO.updateStudent(student);
//        List<Course> courses = studentDAO.getAllCourses(semester);
//        for(int i = 0; i < courses.size(); i++){
//            if(courses.get(i).isIsPractice()){
//                marks = new Marks(usn, testOne, testTwo, testThree, testAverage, quizOne, quizTwo, assignment, cie, labManual, labTest, labCie, cieTotal, theorySee, labSee, seeTotal, grandTotal, '-');
//                marksDAO.insertMarks(courses.get(i).getCode(), courses.get(i).isIsPractice(), marks);
//            }
//            else{
//                marks = new Marks(usn, testOne, testTwo, testThree, testAverage, quizOne, quizTwo, assignment,cieTotal, seeTotal, grandTotal, '-');
//                marksDAO.insertMarks(courses.get(i).getCode(), courses.get(i).isIsPractice(), marks);
//            }
//        }
        response.sendRedirect("listStudents");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String usn = request.getParameter("usn");
        userDAO.deleteUser(usn);
        studentDAO.deleteStudent(usn);
        response.sendRedirect("listStudents");

    }
    
    private void showStudentSemesters(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        String usn = request.getParameter("usn");
        List<Integer> semesters = studentDAO.getStudentSemesters(usn);
        request.setAttribute("usn", usn);
        request.setAttribute("semesters", semesters);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-semesters-list.jsp");
        dispatcher.forward(request, response);
    }
   
    private void listStudentCourses(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        MarksDAO marksDAO = new MarksDAO();
        String usn = request.getParameter("usn");
        int semester = Integer.parseInt(request.getParameter("semester"));
        List<Course> courses = marksDAO.selectSingleStudentCourses(usn, semester);
        request.setAttribute("usn", usn);
        request.setAttribute("semester", semester);
        request.setAttribute("courses", courses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("registered-courses-list.jsp");
        dispatcher.forward(request, response);
    }
    
    private void studentSGPA(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        MarksDAO marksDAO = new MarksDAO();
        String usn = request.getParameter("usn");
        int totalCreditPoints = 0;
        int totalCredits = 0;
        int sgpa = 0;
        int semester = Integer.parseInt(request.getParameter("semester"));
        List<Course> courses = marksDAO.selectSingleStudentCourses(usn, semester);
        List<Result> results = new ArrayList<>();
        for(Course course: courses){
            results.add(studentDAO.selectCourseMarks(course.getCode(), usn));
        }
        System.out.println(results);
        for(Result result: results){
            totalCredits += result.getCourseCredits();
            totalCreditPoints += (result.getGradePoint() * result.getCourseCredits());
        }
        sgpa = totalCreditPoints / totalCredits;
        request.setAttribute("usn", usn);
        request.setAttribute("semester", semester);
        request.setAttribute("results", results);
        request.setAttribute("sgpa", sgpa);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-result-page.jsp");
        dispatcher.forward(request, response);
    }
    
    private void registerToCourse(HttpServletRequest request, HttpServletResponse response) // For Electives
    throws SQLException, IOException {
        String usn = request.getParameter("usn");
        String code = request.getParameter("code");
        System.out.println(request.getParameter("semester"));
        int semester = Integer.parseInt(request.getParameter("semester"));
        studentDAO.registerForCourse(code, usn);
        response.sendRedirect("listStudentCourses?usn="+usn+"&semester="+semester);
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
