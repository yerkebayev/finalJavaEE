package com.example.demo.servlets;

import com.example.demo.db.Comment;
import com.example.demo.db.DBConnection;
import com.example.demo.db.News;
import com.example.demo.db.NewsCategory;
import com.example.demo.db_impl.CommentImpl;
import com.example.demo.db_impl.NewsCategoryImpl;
import com.example.demo.db_impl.NewsWorksImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBConnection dbConnection = new DBConnection();
        NewsWorksImpl newsWorksImpl = new NewsWorksImpl(dbConnection.getConnection());
        NewsCategoryImpl newsCategoryImpl = new NewsCategoryImpl(dbConnection.getConnection());
        CommentImpl commentImpl = new CommentImpl(dbConnection.getConnection());
        long id;
        try {
            id = Long.parseLong(request.getParameter("news_id"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        News news = newsWorksImpl.getNews(id);
        request.setAttribute("foundNews",news);
        List<NewsCategory> categories = newsCategoryImpl.getCategories();
        request.setAttribute("categories",categories);
        List<Comment> comments = commentImpl.getComments(id);
        request.setAttribute("comments",comments);
        request.getRequestDispatcher("/details.jsp").forward(request,response);
    }
}
