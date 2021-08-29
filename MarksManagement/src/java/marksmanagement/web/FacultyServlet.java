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
import marksmanagement.dao.FacultyDAO;
import marksmanagement.dao.UserDAO;
import marksmanagement.model.Course;
import marksmanagement.model.Faculty;
import marksmanagement.model.User;

/**
 *
 * @author mnpem
 */

public class FacultyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private FacultyDAO facultyDAO;
    private UserDAO userDAO;
    final private String userType = "faculty";
    
    @Override
    public void init(){
        facultyDAO = new FacultyDAO();
        userDAO = new UserDAO();
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
                case "/newFaculty":
                    showFacultyForm(request, response);
                    break;
                case "/insertFaculty":
                    insertFaculty(request, response);
                    break;
                case "/deleteFaculty":
                    deleteFaculty(request, response);
                    break;
                case "/editFaculty":
                    showEditFacultyForm(request, response);
                    break;
                case "/updateFaculty":
                    updateFaculty(request, response);
                    break;
                case "/listFaculties":
                    listFaculties(request, response);
                        break;
                case "/listCoursesHandled":
                    coursesHandled(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void listFaculties(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List <Faculty> listFaculties = facultyDAO.selectAllFaculties();
        request.setAttribute("listFaculty", listFaculties);
        RequestDispatcher dispatcher = request.getRequestDispatcher("faculty-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showFacultyForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("faculty-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFacultyForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        Faculty existingFaculty = facultyDAO.selectFaculty(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("faculty-form.jsp");
        request.setAttribute("faculty", existingFaculty);
        dispatcher.forward(request, response);

    }

    private void insertFaculty(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String id = request.getParameter("id");
        String designation = request.getParameter("designation");
        String fullName =  request.getParameter("name");
        String collegeEmail = request.getParameter("email");
        Faculty newFaculty = new Faculty(id, designation, fullName, collegeEmail);
        facultyDAO.insertFaculty(newFaculty);
        User user = new User(id);
        userDAO.insertUser(user, userType);
        response.sendRedirect("listFaculties");
    }

    private void updateFaculty(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String id = request.getParameter("id");
        String designation = request.getParameter("designation");
        String fullName = request.getParameter("name");
        String collegeEmail = request.getParameter("email");
        Faculty faculty = new Faculty(id, designation, fullName, collegeEmail);
        facultyDAO.updateFaculty(faculty);
        response.sendRedirect("listFaculties");
    }

    private void deleteFaculty(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String id = request.getParameter("id");
        userDAO.deleteUser(id);
        facultyDAO.deleteFaculty(id);
        response.sendRedirect("listFaculties");

    }
    
    private void coursesHandled(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        String id = request.getParameter("id");
        List <Course> listCoursesHandled = facultyDAO.selectCoursesHandled(id);
        request.setAttribute("listCoursesHandled", listCoursesHandled);
        RequestDispatcher dispatcher = request.getRequestDispatcher("course-handled-list.jsp");
        dispatcher.forward(request, response);
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
