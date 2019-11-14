<%--
  Created by IntelliJ IDEA.
  User: Le Van Tuan
  Date: 08-Nov-19
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Spring Security Tutorial</title>
    <link rel="stylesheet" type="text/css" th:href="@{/css/login.css}"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <form th:action="@{/login}" method="POST" class="form-signin">
        <h3 class="form-signin-heading" th:text="Welcome"></h3>
        <br/>

        <input type="text" id="accNumber" name="accNumber" th:placeholder="Enter Account Number"
               class="form-control"/> <br/>
        <input type="password" th:placeholder="Enter Pin Number"
               id="pinNumber" name="pinNumber" class="form-control"/> <br/>

        <div align="center" th:if="${param.error}">
            <p style="font-size: 20; color: #FF1C19;">Invalid Account Number or PIN</p>
        </div>
        <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit"
                th:text="Login"></button>
    </form>
</div>
</body>
</html>