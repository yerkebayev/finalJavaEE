package com.example.demo.servlets;

import com.example.demo.db.Comment;
import com.example.demo.db.DBConnection;
import com.example.demo.db.User;
import com.example.demo.db_impl.CommentImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/add-comment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        DBConnection dbConnection = new DBConnection();
        CommentImpl commentImpl = new CommentImpl(dbConnection.getConnection());
        if(user != null){
            String commentText = request.getParameter("comment");
            Long newsId = Long.parseLong(request.getParameter("news_id"));
            Comment comment = new Comment();
            comment.setComment(commentText);
            comment.setUser_id(user.getId());
            comment.setNews_id(newsId);
            commentImpl.addComment(comment);
            response.sendRedirect("/details?news_id="+newsId);
        }else{
            response.sendRedirect("/login");
        }
    }
}