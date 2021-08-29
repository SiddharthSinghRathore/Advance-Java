

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/Com1"})

public class Com1 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Companies</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Com1 at " + request.getContextPath() + "</h1>");
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
    
        try
        {
            
        String cname,customername,address,Quotation,email,Quotation_Date,Quotation_Validity,phone;  
        PrintWriter out=response.getWriter();
      
        cname=request.getParameter("CompanyName");
        customername=request.getParameter("CustomerName");
        
        phone=request.getParameter("CustomerName");
        address=request.getParameter("address");
        email=request.getParameter("email");
        Quotation=request.getParameter("Quotation");
        Quotation_Date=request.getParameter("Date");
        Quotation_Validity=request.getParameter("Validity");
        
        
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=Quotation.xls");
        
        out.println("Company Name\tCustomerName\tAddress\tEmail\tQuotation\tQuotation Date\tQuotation Validaty");
 out.println(cname+"\t"+customername+"\t"+"\t"+phone+"\t"+address+"\t"+email+"\t"+Quotation+"\t"+Quotation_Date+"\t" +Quotation_Validity);
        }
         catch (Exception e) {
                e.printStackTrace(); /* Throw exceptions to log files */
        }
        
        
      
    }

   
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    class ITextRenderer {

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
    }

}
