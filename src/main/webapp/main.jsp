<%@ page import="com.example.demo.db.News" %>
<%@ page import="com.example.demo.db.NewsCategory" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <div class="container mt-3">
        <div class="row mt-3">
            <div class="col-12">
                <%if (currentUser != null && currentUser.getRole_id() == 1) {%>
                <button type="button" class="btn btn-sm bg-warning text-bg-secondary" data-bs-toggle="modal" data-bs-target="#addTask" style="background-color: blue">Add news</button>
                <form action="/add-news" method="post">
                        <div class="modal fade" id="addTask" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="exampleModalLabel">New News</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="row">
                                            <div class="col-12">
                                                <label>Category: </label>
                                            </div>
                                        </div>
                                        <div class="row mt-2">
                                            <div class="col-12">
                                                <label>
                                                    <select class="form-control" name="news_category_id">
                                                        <%List<NewsCategory> newsCategories = (List<NewsCategory>) request.getAttribute("newsCategory");
                                                            if (newsCategories != null) {
                                                                for(NewsCategory nc: newsCategories){%>
                                                        <option value="<%=nc.getId()%>"><%=nc.getName()%></option>
                                                        <%}}%>
                                                    </select>
                                                </label>
                                            </div>
                                        </div>
                                        <div class="row mt-3">
                                            <div class="col-12">
                                                <label>Title: </label>
                                            </div>
                                        </div>
                                        <div class="row mt-2">
                                            <div class="col-12">
                                                <label>
                                                    <input type="text" class="form-control" name="title">
                                                </label>
                                            </div>
                                        </div>
                                        <div class="row mt-3">
                                            <div class="col-12">
                                                <label>Content: </label>
                                            </div>
                                        </div>
                                        <div class="row mt-2">
                                            <div class="col-12">
                                                <label>
                                                    <textarea type="text" class="form-control" name="content" rows="5"></textarea>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary text-warning" data-bs-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-warning">Add</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                <%}%>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-12">
                <%
                    List<News> newsArrayList = (List<News>) request.getAttribute("news");
                    if (newsArrayList != null) {
                        for(News n: newsArrayList){
                %>
                        <div class="card mb-3 border border-info" style="max-width: 540px;">
                            <div class="row g-0">
                                <div class="col-md-8">
                                    <div class="card-body">
                                        <p class="card-text"><%=n.getId()%></p>
                                        <h5 class="card-title"><%=n.getTitle()%></h5>
                                        <p class="card-text"><%=n.getContent()%></p>
                                        <p class="card-text"><small class="text-body-secondary"><%=n.getPost_date()%></small></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                <%}}%>
            </div>
        </div>
    </div>
</body>
</html>
