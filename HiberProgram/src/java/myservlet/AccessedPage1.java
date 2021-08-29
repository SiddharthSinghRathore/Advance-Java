/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Administrator
 */
public class AccessedPage1 extends HttpServlet {
 Configuration config = new Configuration().configure();
    SessionFactory sf = config.buildSessionFactory();
    Session s = sf.openSession();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AccessedPage1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AccessedPage1 at " + request.getContextPath() + "</h1>");
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
      String un = request.getParameter("username");
        String pass = request.getParameter("password");
        Transaction t = s.beginTransaction();
        Session s = sf.openSession();
        Query q = s.createQuery("from Login where username = '"+un+"' and password='"+pass+"'");
        List<Login> l = q.list();
        System.out.println("usernamne"+un+" pass"+pass);
        if(!l.isEmpty()){
        Login lg = l.get(0);
        if(lg.username.equalsIgnoreCase(un)&& lg.password.equalsIgnoreCase(pass)){
            try (PrintWriter out = response.getWriter()) {
                out.println("Login Accepted");
            }
        }else{
            try (PrintWriter out = response.getWriter()) {
                out.println("Invalid Login");
            }
        }
        }else{
            try (PrintWriter out = response.getWriter()) {
                out.println("username/password is not found");
            }
        }
        t.commit();
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
        processRequest(request, response);
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
