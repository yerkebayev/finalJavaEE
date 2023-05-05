package com.example.demo.servlets;

import com.example.demo.db.DBConnection;
import com.example.demo.db.News;
import com.example.demo.db.NewsCategory;
import com.example.demo.db.User;
import com.example.demo.service.NewsCategoryService;
import com.example.demo.service.NewsWorksService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/edit-news")
public class UpdateNewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User currentUser = (User)request.getSession().getAttribute("currentUser");
        DBConnection dbConnection = new DBConnection();
        NewsWorksService newsWorksService = new NewsWorksService(dbConnection.getConnection());
        NewsCategoryService newsCategoryService = new NewsCategoryService(dbConnection.getConnection());
        if(currentUser!=null && currentUser.getRole_id().equals(1)) {
            Long news_id = Long.parseLong(request.getParameter("id"));
            int category_id = Integer.parseInt(request.getParameter("category_id"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            News news = newsWorksService.getNews(news_id);
            NewsCategory newsCategory = newsCategoryService.getCategory(category_id);
            if (news != null && newsCategory != null) {
                news.setTitle(title);
                news.setContent(content);
                news.setNewsCategory(category_id);
                newsWorksService.updateNews(news);
                response.sendRedirect("/details?news_id=" + news_id);
            } else {
                response.sendRedirect("/");
            }
        }else {
            response.sendRedirect("/");
        }
    }
}