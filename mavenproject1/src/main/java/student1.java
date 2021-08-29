/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.lang.model.SourceVersion;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author siddharthsinghrathour
 */
@WebServlet(urlPatterns = {"/student1"})

public class student1 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet student1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet student1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        doPost(request, response);
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
     // OutputStream out = response.getOutputStream(); 

        try
        {
        String college,name,dob,pskill,pgmarks,project;
        float per;
       /* response.setContentType("application/pdf");
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(document,null);

        renderer.setDocumentFromString(request.getParameter("collage"));       
        renderer.setDocumentFromString(request.getParameter("name"));
        renderer.setDocumentFromString(request.getParameter("dob"));
        renderer.setDocumentFromString(request.getParameter("pgmarks"));
        renderer.setDocumentFromString(request.getParameter("pskill"));
        renderer.setDocumentFromString(request.getParameter("project"));
        renderer.layout(); 
        renderer.createPDF(out,true);*/
        
        PrintWriter out=response.getWriter();
        response.setContentType("application/pdf");
        college=request.getParameter("college");
        name=request.getParameter("name");
    
        dob=request.getParameter("dob");
        pgmarks=request.getParameter("pgmarks");
        pskill=request.getParameter("pskill");
        project=request.getParameter("project");
        out.println("<html><body>");
        out.println("<b><i><h2>    RESUME :</h2></b></i><br>");
        out.println("<b><i>COLLEGE :</b></i>"+college+"<br>");
        out.println("<b><i>NAME :</b></i>"+name+"<br>");
        out.println("<b><i>DATE-OF-BIRTH :</b></i>"+dob+"<br>");
        out.println("<b><i>PG-MARKS:</b></i>"+pgmarks+"<br>");
        out.println("<b><i>PROGRAMMING-SKILL:</b></i>"+pskill+"<br>");
        out.println("<b><i>PROJECT-WORK:</b></i>"+project+"<br>");    
        }
         catch (Exception e) {
                e.printStackTrace(); /* Throw exceptions to log files */
        }
        
        
      
    }

   
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private static class ITextRenderer {

        public ITextRenderer() {
        }

        private void setDocumentFromString(String parameter) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void layout() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void createPDF(OutputStream out) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void createPDF(OutputStream out, boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public SourceVersion getSupportedSourceVersion() {
            return SourceVersion.RELEASE_7;
        }
    }

}
