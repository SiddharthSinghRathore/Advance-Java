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
import marksmanagement.dao.CourseDAO;
import marksmanagement.dao.SchemeDAO;
import marksmanagement.model.Course;
import marksmanagement.model.Scheme;

/**
 *
 * @author mnpem
 */

public class CourseServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private CourseDAO courseDAO;
    private SchemeDAO schemeDAO;
    
    @Override
    public void init(){
        courseDAO = new CourseDAO();
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
                case "/newCourse":
                    showCourseForm(request, response);
                    break;
                case "/insertCourse":
                    insertCourse(request, response);
                    break;
                case "/deleteCourse":
                    deleteCourse(request, response);
                    break;
                case "/editCourse":
                    showCourseEditForm(request, response);
                    break;
                case "/updateCourse":
                    updateCourse(request, response);
                    break;
                case "/listCourses":
                    listCourses(request, response);
                        break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
     private void listCourses(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List <Course> listCourses = courseDAO.selectAllCourses();
        request.setAttribute("listCourse", listCourses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("course-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCourseForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        List<Scheme> schemeYears = schemeDAO.selectAllSchemes();
        request.setAttribute("schemeYears", schemeYears);
        RequestDispatcher dispatcher = request.getRequestDispatcher("course-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showCourseEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        List<Scheme> schemeYears = schemeDAO.selectAllSchemes();
        request.setAttribute("schemeYears", schemeYears);
        String code = request.getParameter("code");
        Course existingCourse = courseDAO.selectCourse(code);
        RequestDispatcher dispatcher = request.getRequestDispatcher("course-form.jsp");
        request.setAttribute("course", existingCourse);
        dispatcher.forward(request, response);

    }

    private void insertCourse(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        int semester = Integer.parseInt(request.getParameter("semester"));
        int schemeYear = Integer.parseInt(request.getParameter("schemeYear"));
        boolean isPractice = request.getParameter("isPractice") != null;
        boolean isElective = request.getParameter("isElective") != null;
        String facultyOneId = request.getParameter("facultyOneId");
        String facultyTwoId = request.getParameter("facultyTwoId");
        int credits = Integer.parseInt(request.getParameter("credits"));
        System.out.println(facultyTwoId);
        Course newCourse = new Course(code, name, semester, schemeYear, isPractice, isElective, facultyOneId, facultyTwoId, credits);
        courseDAO.insertCourse(newCourse);
        courseDAO.createCourseTable(code, isPractice);
        response.sendRedirect("listCourses");
    }

    private void updateCourse(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        int semester =  Integer.parseInt(request.getParameter("semester"));
        int schemeYear = Integer.parseInt(request.getParameter("schemeYear"));
        boolean isPractice = request.getParameter("isPractice") != null;
        boolean isElective = request.getParameter("isElective") != null;
        String facultyOneId = request.getParameter("facultyOneId");
        String facultyTwoId = request.getParameter("facultyTwoId");
        int credits = Integer.parseInt(request.getParameter("credits"));
        Course course = new Course(code, name, semester, schemeYear, isPractice, isElective, facultyOneId, facultyTwoId, credits);
        courseDAO.updateCourse(course);
        response.sendRedirect("listCourses");
    }

    private void deleteCourse(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String code = request.getParameter("code");
        courseDAO.deleteCourse(code);
        response.sendRedirect("listCourses");
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
