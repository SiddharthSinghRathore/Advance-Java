/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author siddharthsinghrathour
 */
public class Lab5 extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Lab5</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Lab5 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            ServletContext sc = getServletContext();
            ServletConfig sg = getServletConfig();
            response.setContentType("text/html");
            PrintWriter out= response.getWriter();
            try
            {
                out.println("<html>");
                out.println("<body>");
                out.println("<br><b>Context Method </b>");
                out.println("<ol>");
                String str1=sc.getInitParameter("Mobile");
                String str2=sc.getInitParameter("City");
                
                out.println("<br><li>Mobile Name: "+str1 +"</li>");
                out.println("<br><li>City Name: "+str2 +"</li>");
                out.println("<br><li>Server Info: "+sc.getServerInfo() +"</li>");
                out.println("<br><li>Context Path: "+sc.getContextPath() +"</li>");
                out.println("<br><li>Attributes Name: "+sc.getAttributeNames() +"</li>");
                out.println("<br><li>Context Path: "+sc.getVirtualServerName() +"</li>");       
                out.println("<br><li>Minir Version: "+sc.getMinorVersion() +"</li>");       
                out.println("<br><li>MIME: "+sc.getDefaultSessionTrackingModes() +"</li>");       
                
                out.println("</ol>");
                
                out.println("<ol>");
                out.println("<br><li>Servlet Name: "+sg.getServletName() +"</li>");
                out.println("<br><li>Class Name: "+sg.getClass() +"</li>");
                out.println("<br><li>Context Name: "+sg.getServletContext() +"</li>");
                String str3=sc.getInitParameter("USN");
                String str4=sc.getInitParameter("NAME");
                
                out.println("<br><li>USN: "+str3 +"</li>");
                out.println("<br><li>NAME: "+str4 +"</li>");
                
                
                
                out.println("</ol>");
                
                out.println("</body>");
                out.println("</html>");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    
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
