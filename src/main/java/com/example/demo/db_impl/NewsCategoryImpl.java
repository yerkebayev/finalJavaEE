package com.example.demo.db_impl;

import com.example.demo.db.NewsCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NewsCategoryImpl {
    Connection connection;
    public NewsCategoryImpl(Connection connection) {
        this.connection = connection;
    }
    public NewsCategory getCategory(int id) {
        NewsCategory newsCategory = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM news_categories WHERE id = ?")){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                newsCategory = new NewsCategory(resultSet.getInt("id"), resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsCategory;
    }
    public List<NewsCategory> getCategories() {
        List<NewsCategory> newsCategoryArrayList = new ArrayList<>();
        try (
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM news_categories ")){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                NewsCategory newsCategory = new NewsCategory(resultSet.getInt("id"), resultSet.getString("name"));
                newsCategoryArrayList.add(newsCategory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsCategoryArrayList;
    }
}
