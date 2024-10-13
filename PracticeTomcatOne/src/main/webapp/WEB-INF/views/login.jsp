<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
    <h2>Login</h2>
    <form action="/checklogin" method="post">
        <label for="userid">User ID:</label>
        <input type="text" id="userid" name="UserId"><br>
        <label for="passwd">Password:</label>
        <input type="password" id="passwd" name="UserPasswd"><br>
        <button type="submit">Login</button>
    </form>
    <br>
    <a href="/register">회원가입</a>
	<a href="/BankSystem">Use Bank System</a>
</body>
</html>
