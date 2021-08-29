/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.sun.tools.javac.tree.TreeInfo.name;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
        
        response.setContentType("text/html");

        PrintWriter out=response.getWriter();
        ServletContext sct=getServletContext();

        out.println("<h1>ConFig Method</h1>");
        out.println("<ol>");
        
        ServletConfig scg=getServletConfig();
        String str3=scg.getInitParameter("Mobile");
        String str4=scg.getInitParameter("city");
        out.println("<br>"+"<li><b>"+str3+"</b></li>");
        out.println("<br>"+"<li><b>"+str4+"</b></li>");
        out.println("<br><li><b>ServletName:"+scg.getServletName()+"</b></li>");
        out.println("<br><li><b>Servlet Context Name:"+scg.getServletContext()+"</b></li>");

       
        out.println("</ol>");
        
        
        out.println("<h1>Context Method</h1>");
        out.println("<ol>");
      
        String str1=sct.getInitParameter("name");
        out.println("<br>"+"<li><b>"+str1+"</b></li>");
        String str2=sct.getInitParameter("USN");
        out.println("<br>"+"<li><b>"+str2+"</b></li>");
        
        out.println("<br><li><b>Servlet Info:"+sct.getServerInfo()+"</b></li>");
        out.println("<br><li><b>Context Path:"+sct.getContextPath()+"</b></li>");
        out.println("<br><li><b>Attributes name:"+sct.getAttributeNames()+"</b></li>");
        out.println("<br><li><b>Major Version of the Java Servlet:"+sct.getMajorVersion()+"</b></li>");
        out.println("<br><li><b>Minor Version of the Java Servlet:"+sct.getMinorVersion()+"</b></li>");

        RequestDispatcher dispatch = request.getRequestDispatcher("/info");
        out.println("<br><li><b>RequestDispatcher::"+dispatch+"</b></li>");
        



        out.println("</ol>");
        
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
