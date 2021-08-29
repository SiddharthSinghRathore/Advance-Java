
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author siddharthsinghrathour
 */
public class Lab4 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Lab4</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Lab4 at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setContentType("text/html");            
            PrintWriter out=response.getWriter();
            ServletConfig sc=getServletConfig();
            String username=request.getParameter("t1");
            String password=request.getParameter("t2");
            if(username.equalsIgnoreCase(sc.getInitParameter("username")) && password.equalsIgnoreCase(sc.getInitParameter("password")))
            {
                out.println("<html>");
                out.println("<body>");
                out.println("<h1> Verified UserName And Password </h1>");                
                out.println("</body>");                                
                out.println("</html>");
                
            }
            else
            {
                out.println("<html>");
                out.println("<body>");
                out.println("<h1> Not Verified UserName And Password </h1>");                
                out.println("</body>");                                
                out.println("</html>");
                
            }
            
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
