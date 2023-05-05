package com.example.demo.servlets;

import com.example.demo.db.DBConnection;
import com.example.demo.db.User;
import com.example.demo.db_impl.NewsWorksImpl;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete-news")
public class DeleteNewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DBConnection dbConnection = new DBConnection();
        NewsWorksImpl newsWorksImpl = new NewsWorksImpl(dbConnection.getConnection());
        long id;
        try {
            id = Long.parseLong(request.getParameter("news_id"));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        User currentUser = (User)request.getSession().getAttribute("currentUser");
        if(currentUser!=null && currentUser.getRole_id().equals(1)) {
            newsWorksImpl.removeNews(id);
        }
        response.sendRedirect("/");
    }
}