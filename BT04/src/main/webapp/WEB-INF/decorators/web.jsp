<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">

    <title>
        <sitemesh:write property="title"/>
    </title>

    <style>

        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }

        .header {
            background-color: #333;
            color: white;
            padding: 20px;
        }

        nav {
            background-color: #eee;
            padding: 15px;
        }

        nav a {
            text-decoration: none;
            margin-right: 20px;
        }

        .content {
            padding: 30px;
        }

        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 15px;
            margin-top: 30px;
        }

    </style>

</head>

<body>

    <%@ include file="/common/web/header.jsp"%>

    <%@ include file="/common/web/navbar.jsp"%>

    <div class="content">

        <sitemesh:write property="body"/>

    </div>

    <%@ include file="/common/web/footer.jsp"%>

</body>

</html>