package com.hibernateweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hibernateweb.bean.User;
import com.hibernateweb.dao.UserDAO;


/**
 * Servlet implementation class UserControllerServlet
 */

public class UserControllerServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String city = request.getParameter("city");
        User user;
 
        
        try {
            UserDAO userDAO = new UserDAO();
            user = userDAO.addUserDetails(userName, password, email, phone, city);
            System.out.println(user);
            if(user != null) {
            	HttpSession session=request.getSession();
                session.setAttribute("currentsession", user);
                response.sendRedirect("success.jsp");
            }else{
                response.sendRedirect("failure.jsp");
               
            }
        } catch (Exception e) {
 
            e.printStackTrace();
        }
 
    }
}