package com.example.demo.service;

import com.example.demo.db.News;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsWorksService {
    Connection connection;
    public NewsWorksService(Connection connection) {
        this.connection = connection;
    }
    public void addNews(News news) {
        try(PreparedStatement statement = connection.prepareStatement("INSERT INTO news (category_id, post_date, title, content) VALUES (?, NOW(), ?, ?)")) {
            statement.setInt(1, news.getNewsCategory());
            statement.setString(2, news.getTitle());
            statement.setString(3, news.getContent());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<News> getNews() {
        List<News> news = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT n.id, n.post_date, n.category_id, n.title, n.content FROM news n " +
                        "JOIN news_categories nc ON n.category_id = nc.id " +
                        "ORDER BY n.post_date DESC");
             ResultSet resultSet = statement.executeQuery())
        {
            while (resultSet.next()) {
                News n = new News(resultSet.getLong(1),resultSet.getTimestamp(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getString(5));
                news.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    public News getNews(Long id) {
        News news = null;
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT n.id, n.post_date, n.category_id, n.title, n.content FROM news n " +
                        "JOIN news_categories nc ON n.category_id = nc.id " +
                        "WHERE n.id = ?"))
        {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                news = new News(resultSet.getLong(1),resultSet.getTimestamp(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

    public void updateNews(News news) {
        try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE news SET " +
                            "category_id = ?, " +
                            "title = ?, " +
                            "content = ? WHERE id = ?")){
            statement.setInt(1, news.getNewsCategory());
            statement.setString(2, news.getTitle());
            statement.setString(3, news.getContent());
            statement.setLong(4, news.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeNews(Long id) {
        try (PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM news WHERE id = ?")) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
