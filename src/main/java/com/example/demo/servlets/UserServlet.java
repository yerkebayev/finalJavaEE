package com.example.demo.servlets;

import com.example.demo.db.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/profile")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if(currentUser!=null) {
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }
}