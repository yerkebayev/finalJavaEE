package com.example.demo.servlets;

import com.example.demo.db.DBConnection;
import com.example.demo.db.News;
import com.example.demo.db.NewsCategory;
import com.example.demo.db.User;
import com.example.demo.db_impl.NewsCategoryImpl;
import com.example.demo.db_impl.NewsWorksImpl;

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
        NewsWorksImpl newsWorksImpl = new NewsWorksImpl(dbConnection.getConnection());
        NewsCategoryImpl newsCategoryImpl = new NewsCategoryImpl(dbConnection.getConnection());
        if(currentUser!=null && currentUser.getRole_id().equals(1)) {
            Long news_id = Long.parseLong(request.getParameter("id"));
            int category_id = Integer.parseInt(request.getParameter("category_id"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            News news = newsWorksImpl.getNews(news_id);
            NewsCategory newsCategory = newsCategoryImpl.getCategory(category_id);
            if (news != null && newsCategory != null) {
                news.setTitle(title);
                news.setContent(content);
                news.setNewsCategory(category_id);
                newsWorksImpl.updateNews(news);
                response.sendRedirect("/details?news_id=" + news_id);
            } else {
                response.sendRedirect("/");
            }
        }else {
            response.sendRedirect("/");
        }
    }
}