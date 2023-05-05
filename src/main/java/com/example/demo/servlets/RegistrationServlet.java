package com.example.demo.servlets;

import com.example.demo.db.DBConnection;
import com.example.demo.db.User;
import com.example.demo.service.UserWorksService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullName = request.getParameter("full_name");
        DBConnection dbConnection = new DBConnection();
        UserWorksService userWorksService = new UserWorksService(dbConnection.getConnection());
        User user = userWorksService.getUser(email);
        if(user == null){
                User newUser = new User();
                newUser.setEmail(email);
                newUser.setFullname(fullName);
                newUser.setPassword(password);
                newUser.setRole_id(2);
                userWorksService.addUser(newUser);
                response.sendRedirect("/register?cool");
        }else{
            response.sendRedirect("/register?Error");
        }
    }
}