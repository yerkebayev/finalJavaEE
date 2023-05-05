package com.example.demo.servlets;

import com.example.demo.db.DBConnection;
import com.example.demo.db.User;
import com.example.demo.service.UserWorksService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/edit-profile")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");
        DBConnection dbConnection = new DBConnection();
        UserWorksService userWorksService = new UserWorksService(dbConnection.getConnection());
        User user = userWorksService.getUser(email);
        if(user!=null){
            user.setFullname(fullName);
            user.setPassword(password);
            userWorksService.updateUser(user);
            request.getSession().removeAttribute("currentUser");
            HttpSession session = request.getSession();
            session.setAttribute("currentUser",user);
            response.sendRedirect("/profile");
        }else{
            response.sendRedirect("/");
        }
    }
}