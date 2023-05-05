package com.example.demo.servlets;

import com.example.demo.db.DBConnection;
import com.example.demo.db.User;
import com.example.demo.db_impl.UserWorksImpl;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DBConnection dbConnection = new DBConnection();
        UserWorksImpl userWorksImpl = new UserWorksImpl(dbConnection.getConnection());
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userWorksImpl.getUser(email);
        if(user != null && user.getPassword().equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("currentUser",user);
            response.sendRedirect("/profile");
        }else{
            response.sendRedirect("/login");
        }
    }
}