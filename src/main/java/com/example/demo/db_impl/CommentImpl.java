package com.example.demo.db_impl;

import com.example.demo.db.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentImpl {
    Connection connection;

    public CommentImpl(Connection connection) {
        this.connection = connection;
    }

    public void addComment(Comment comment){
        try (
            PreparedStatement statement = connection.prepareStatement("INSERT INTO comments (post_date, comment, user_id, news_id) VALUES (NOW(),?,?,?)")) {
            statement.setString(1,comment.getComment());
            statement.setLong(2,comment.getId());
            statement.setLong(3,comment.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public List<Comment> getComments(Long newsID){
        List<Comment> comments = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT c.id, c.post_date, c.comment, c.user_id, u.full_name, c.news_id FROM comments c " +
                            "JOIN users u ON c.user_id = u.id " +
                            "WHERE c.news_id = ? "
            );
            statement.setLong(1,newsID);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Comment comment = new Comment(resultSet.getLong("id"), resultSet.getString("comment"),resultSet.getTimestamp("post_date"),resultSet.getLong("news_id") ,resultSet.getLong("user_id") ) ;
                comments.add(comment);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return comments;
    }
}
