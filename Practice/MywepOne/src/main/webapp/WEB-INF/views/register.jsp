<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Page</title>
</head>
<body>
    <h2>회원가입</h2>
    <form action="/register" method="post">
        <label for="userid">User ID:</label>
        <input type="text" id="userid" name="UserId"><br> <!-- 엔티티의 UserId 필드와 일치 -->
        
        <label for="passwd">Password:</label>
        <input type="password" id="passwd" name="UserPasswd"><br> <!-- 엔티티의 UserPasswd 필드와 일치 -->
        
        <label for="username">Name:</label>
        <input type="text" id="username" name="UserName"><br> <!-- 엔티티의 UserName 필드와 일치 -->
        
        
        <button type="submit">Register</button>
    </form>
</body>
</html>
