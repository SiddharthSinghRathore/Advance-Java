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
import marksmanagement.dao.SchemeDAO;
import marksmanagement.model.Scheme;

/**
 *
 * @author mnpem
 */

public class SchemeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private SchemeDAO schemeDAO;

    @Override
    public void init(){
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
                case "/newScheme":
                    showSchemeForm(request, response);
                    break;
                case "/insertScheme":
                    insertScheme(request, response);
                    break;
                case "/deleteScheme":
                    deleteScheme(request, response);
                    break;
//                case "/editScheme":
//                    showEditSchemeForm(request, response);
//                    break;
//                case "/updateScheme":
//                    updateScheme(request, response);
//                    break;
                case "/listSchemes":
                    listSchemes(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void listSchemes(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List <Scheme> listSchemes = schemeDAO.selectAllSchemes();
        request.setAttribute("listSchemes", listSchemes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("scheme-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showSchemeForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("scheme-form.jsp");
        dispatcher.forward(request, response);
    }

//    private void showEditSchemeForm(HttpServletRequest request, HttpServletResponse response)
//    throws SQLException, ServletException, IOException {
//        int schemeYear = Integer.parseInt(request.getParameter("schemeYear"));
//        Scheme existingScheme = schemeDAO.selectScheme(schemeYear);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("scheme-form.jsp");
//        request.setAttribute("scheme", existingScheme);
//        dispatcher.forward(request, response);
//
//    }

    private void insertScheme(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int schemeYear = Integer.parseInt(request.getParameter("schemeYear"));
        Scheme newScheme = new Scheme(schemeYear);
        schemeDAO.insertScheme(newScheme);
        response.sendRedirect("listSchemes");
    }

//    private void updateScheme(HttpServletRequest request, HttpServletResponse response)
//    throws SQLException, IOException {
//        int schemeYear = Integer.parseInt(request.getParameter("schemeYear"));
//        int numberOfSubjectsPerSemester = Integer.parseInt(request.getParameter("numberOfSubjectsPerSemester"));
//        Scheme scheme = new Scheme(schemeYear, numberOfSubjectsPerSemester);
//        schemeDAO.updateScheme(scheme);
//        response.sendRedirect("listSchemes");
//    }

    private void deleteScheme(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int schemeYear = Integer.parseInt(request.getParameter("schemeYear"));
        schemeDAO.deleteScheme(schemeYear);
        response.sendRedirect("listSchemes");

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
