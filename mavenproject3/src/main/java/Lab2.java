import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author siddharthsinghrathour
 */

@WebServlet(urlPatterns = {"/Lab2"})
public class Lab2 extends HttpServlet {

  public double price1=1245.2f;
  public double price2=2673.2f;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Lab2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Lab2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setIntHeader("Refresh",1); 
        response.setContentType("text/html");
        Calendar calendar=new GregorianCalendar();
        String am_pm;
       
       
        int hour=calendar.get(Calendar.HOUR);
        int minute=calendar.get(Calendar.MINUTE);
        int seconds=calendar.get(Calendar.SECOND);
        if(calendar.get(Calendar.AM_PM)==0)
        {
            am_pm="AM";
        }
        else
        {
            am_pm="PM";
        }
        String ss=hour+":"+minute+":"+seconds+""+am_pm;
        price1=price1*.43;
        price2=price2*1.33;
        // double price1=1245.00;
        // double price2=2673.00;

        // FileWriter fw = new FileWriter("/Users/siddharthsinghrathour/Desktop/price.rtf");
         //fw.write(Double.toString(price1));
         //fw.write(Double.toString(price2));
         //fw.close();
        
        PrintWriter out=response.getWriter();
        out.println("<h1 align='center'>Auto Refresh Page </h1><hr>");
        out.println("<h1 align='center' style=background-color:red>Current Time:"+ss+"</h1>");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body style='background-color:#d3d3d3;'><p><table> <tr><th><h1>Stock</h1></th><th><h1>Price</h1></th></tr> "
                +"<tr><td><h1 style=\"background-color:powderblue;\">PLATINUM</h1></td><td><h1 style=\"background-color:powderblue;\">" 
                +price1+"</h1></td></tr><tr><td><h1 style=\"background-color:powderblue;\">DIAMOND</h1></td><td><h1 style=\"background-color:powderblue;\">" +price2+"</h1></td></tr></table></p>");
        out.println("</body>");
        out.println("</html>");
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        doGet(request,response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
