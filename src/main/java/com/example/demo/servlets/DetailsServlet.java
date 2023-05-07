package com.example.demo.servlets;

import com.example.demo.db.Comment;
import com.example.demo.db.DBConnection;
import com.example.demo.db.News;
import com.example.demo.db.NewsCategory;
import com.example.demo.service.CommentService;
import com.example.demo.service.NewsCategoryService;
import com.example.demo.service.NewsWorksService;

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
        NewsWorksService newsWorksService = new NewsWorksService(dbConnection.getConnection());
        NewsCategoryService newsCategoryService = new NewsCategoryService(dbConnection.getConnection());
        CommentService commentService = new CommentService(dbConnection.getConnection());
        long id;
        try {
            id = Long.parseLong(request.getParameter("news_id"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        News news = newsWorksService.getNews(id);
        request.setAttribute("news",news);
        List<NewsCategory> categories = newsCategoryService.getCategories();
        request.setAttribute("categories",categories);
        List<Comment> comments = commentService.getComments(id);
        request.setAttribute("comments",comments);
        request.getRequestDispatcher("/details.jsp").forward(request,response);
    }
}
