/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marksmanagement.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import marksmanagement.dao.UserDAO;
import marksmanagement.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author mnpem
 */

public class UserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private UserDAO userDAO;
    private static final BCryptPasswordEncoder B_CRYPT_PASSWORD_ENCODER = new BCryptPasswordEncoder();
    
    @Override
    public void init(){
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
                case "/login":
                    showLoginPage(request, response);
                    break;
                case "/authenticate":
                    authenticateUser(request, response);
                    break;
                case "/changePasswordForm":
                    showChangePasswordForm(request, response);
                    break;
                case "/changePassword":
                    changePassword(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showLoginPage(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login-form.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showChangePasswordForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("change-password-form.jsp");
        dispatcher.forward(request, response);
    }

    private void authenticateUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = null;
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        User user = new User(id, password);
        int userType = userDAO.authenticateUser(user);
        request.setAttribute("id", id);
        switch(userType){
            case 0: dispatcher = request.getRequestDispatcher("adminHome.jsp");
                    dispatcher.forward(request, response);
                    break;
            case 1: System.out.println("HI USER");
                    dispatcher = request.getRequestDispatcher("facultyHome.jsp");
                    dispatcher.forward(request, response);
                    break;
            case 2: dispatcher = request.getRequestDispatcher("studentHome.jsp");
                    dispatcher.forward(request, response);
                    break;
            default: response.sendRedirect("login");
                     break;
                
        }
    }
    
    private void changePassword(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        String id = request.getParameter("id");
        String password = userDAO.getOldPassword(id);
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        if(B_CRYPT_PASSWORD_ENCODER.matches(oldPassword, password)){
            userDAO.changePassword(id, newPassword);
            response.sendRedirect("login");
        }
        else{
            response.sendRedirect("changePasswordForm?id="+id);
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
