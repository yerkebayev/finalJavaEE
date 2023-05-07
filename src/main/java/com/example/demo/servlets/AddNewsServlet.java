package com.example.demo.servlets;

import com.example.demo.db.DBConnection;
import com.example.demo.db.News;
import com.example.demo.db.User;
import com.example.demo.service.NewsWorksService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/add-news")
public class AddNewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        DBConnection dbConnection = new DBConnection();
        NewsWorksService newsWorksService = new NewsWorksService(dbConnection.getConnection());
        if(currentUser != null && currentUser.getRole_id() == 1) {
            String title = request.getParameter("news_title");
            String content = request.getParameter("news_content");
            int category_id = Integer.parseInt(request.getParameter("news_category_id"));
            News news = new News();
            news.setTitle(title);
            news.setContent(content);
            news.setNewsCategory(category_id);
            newsWorksService.addNews(news);
        }
        response.sendRedirect("/home");
    }
}