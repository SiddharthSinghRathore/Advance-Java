
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author siddharthsinghrathour
 */
@WebServlet(urlPatterns = {"/Lab3"})
public class Lab3 extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //response.setContentType("text/html");
        String c=request.getParameter("color");
        PrintWriter out=response.getWriter();
        if(c.equals("red"))
            out.println("<body BGCOLOR=red>");
        if(c.equals("green"))
            out.println("<body BGCOLOR=green>");
        if(c.equals("yellow"))
            out.println("<body BGCOLOR=yellow>");
        if(c.equals("blue"))
            out.println("<body BGCOLOR=blue>");
        out.println("<center><h2>The Selected Color is:"+c+"</h2></center>");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
