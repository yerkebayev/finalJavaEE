<%@ page import="com.example.demo.db.News" %>
<%@ page import="com.example.demo.db.NewsCategory" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <title>Edit News</title>
</head>

<body>
<div class="container mt-4 w-75">
    <% News news = (News) request.getAttribute("news"); %>

    <form action="/edit-news" method="post">
        <input type="hidden" name="id" value="<%= news.getId() %>">

        <div class="row">
            <div class="col-12">
                <label>Category:</label>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-12">
                <label>
                    <select class="form-control" name="category_id">
                        <% ArrayList<NewsCategory> categories = (ArrayList<NewsCategory>) request.getAttribute("categories");
                            if (categories != null) {
                                for (NewsCategory newsCategory: categories) { %>
                        <option <%=(newsCategory.getId() == news.getNewsCategory())?"selected":""%> value="<%= newsCategory.getId() %>"><%= newsCategory.getName() %></option>
                        <%       }
                        }
                        %>
                    </select>
                </label>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-12">
                <label>Title:</label>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-12">
                <label>
                    <input type="text" class="form-control" name="title" value="<%= news.getTitle() %>" placeholder="Title...">
                </label>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-12">
                <label>Content:</label>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-12">
                <label>
                    <textarea type="text" class="form-control" name="content" placeholder="Content..." rows="5"><%= news.getContent() %></textarea>
                </label>
            </div>
        </div>

        <button type="submit" class="btn btn-warning mt-3">Update</button>
        <button type="button" class="btn btn-secondary mt-3 ms-3" data-bs-dismiss="modal">Close</button>
    </form>
</div>
</body>
</html>
