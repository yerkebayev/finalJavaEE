<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <div class="container mt-3">
        <div class="row">
            <div class="col-6 mx-auto">
                <%
                    String emailError = request.getParameter("emailError");
                    if (emailError != null){%>
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            Email is busy!
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                <%
                    }%>
                <%
                    String passwordError = request.getParameter("passwordError");
                    if (passwordError != null){%>
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            Password are not same!
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                <%
                    }
                    String cool = request.getParameter("cool");
                    if (cool != null) {%>
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            User created successfully!
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                <%
                    }%>
                <form action="/register" method="post">
                    <div class="row">
                        <div class="col-12">
                            <label>EMAIL: </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <label>
                                <input type="email" class="form-control" name="email" required>
                            </label>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>PASSWORD: </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <label>
                                <input type="password" class="form-control" name="password" required>
                            </label>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>FULL NAME: </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <label>
                                <input type="text" class="form-control" name="full_name" required>
                            </label>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <button style="background-color: #b20b38" class="btn text-warning">Register</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
