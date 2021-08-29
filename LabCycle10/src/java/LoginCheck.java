/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String uname=request.getParameter("uname");
        String pass = request.getParameter("pass");
        Login l = new Login();
        CRUDOperation co = new CRUDOperation();
        l.setUname(uname);
        l.setPassword(pass);
        l=co.getLoginDetails(l);
        if(l.isValid())
        {
            request.setAttribute("uname", l.getUname());
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        }
        else
        {
            response.sendRedirect(request.getContextPath()); 
        }
    }

}
