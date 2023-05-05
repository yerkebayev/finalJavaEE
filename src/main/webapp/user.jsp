<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <%
        if(currentUser!=null){
    %>
        <div class="container mt-3">
            <div class="row">
                <div class="col-9 border border-2 border-warning" style="border-radius: 0 10px 10px 0;">
                    <h1 class="text-center text-warning">Welcome <%=currentUser.getFullname()%></h1>
                    <p class="text-center text-warning-emphasis"><%=currentUser.getRole_id() == 1 ? "admin":"user"%></p>
                </div>
            </div>
        </div>
    <%
        }
    %>

</body>
</html>
