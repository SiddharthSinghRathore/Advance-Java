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


public class SignUp extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Login s = new Login();
        CRUDOperation co = new CRUDOperation();
        PrintWriter pw = response.getWriter();
        if(request.getParameter("pass").equals(request.getParameter("cpass"))){
        s.setUname(request.getParameter("uname"));
        s.setPassword(request.getParameter("pass"));
        boolean val = co.signin(s);
        if(val){
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }else{
            request.setAttribute("uname", request.getParameter("uname"));
            request.setAttribute("msg", "Registration Failure");
            pw.println("failed!");
        }
    }
    else
        {
            pw.println("paswords do not match!");
        }
    }

}
