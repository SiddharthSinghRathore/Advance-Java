/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out=response.getWriter();
            ServletConfig sc=getServletConfig();
            String username=request.getParameter("user1");
            String password=request.getParameter("pass1");
            if(username.equalsIgnoreCase(sc.getInitParameter("username"))&& password.equalsIgnoreCase(sc.getInitParameter("password")))
            {
                
                out.println("<center><h2>Verified Username and Password</h2></center>");

            }
            else
            {
                out.println("<h1>Not Verified Uesername</h1>");
            }
            
            
    }


}
