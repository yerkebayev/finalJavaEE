<html>
<head>
    <title>Login</title>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <div class="container mt-3">
        <div class="row">
            <div class="col-6 mx-auto">
                <form action="/login" method="post">
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
                            <button class="btn text-warning" style="background-color: blue">LOGIN</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
