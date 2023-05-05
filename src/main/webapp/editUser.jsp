<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-color: #0f1e3c;
            color: #fff;
        }
        .btn-warning {
            background-color: #1f4e78;
            border-color: #1f4e78;
        }
        .btn-warning:hover {
            background-color: #3e76a3;
            border-color: #3e76a3;
        }
        .form-control {
            background-color: #1f4e78;
            color: #fff;
            border-color: #1f4e78;
        }
        .form-control:focus {
            background-color: #3e76a3;
            color: #fff;
            border-color: #3e76a3;
            box-shadow: none;
        }
        .form-control-plaintext {
            color: #fff;
        }
        .border-warning {
            border-color: #1f4e78 !important;
        }
    </style>
</head>

<body>
<%@ include file="navbar.jsp" %>
<div class="container mt-3">
    <div class="row">
        <div class="col-9 border border-2 border-warning" style="border-radius: 0 10px 10px 0;">
            <form action="/profileInfEdit" method="post">
                <div class="form-group row mt-2">
                    <label class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <label>
                            <input type="text" readonly class="form-control-plaintext" value="<%= currentUser.getEmail() %>" name="email">
                        </label>
                    </div>
                </div>
                <div class="form-group row mt-3">
                    <label class="col-sm-2 col-form-label">Full Name</label>
                    <div class="col-sm-10">
                        <label>
                            <input type="text" class="form-control" name="fullName" value="<%= currentUser.getFullname() %>">
                        </label>
                    </div>
                </div>
                <div class="form-group row mt-3">
                    <label class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                        <label>
                            <input type="password" class="form-control" name="password">
                        </label>
                    </div>
                </div>
                <div class="form-control row w-25 mt-3" style="margin: 0 auto">
                    <button type="submit" class="btn btn-warning mb-2">Update</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>