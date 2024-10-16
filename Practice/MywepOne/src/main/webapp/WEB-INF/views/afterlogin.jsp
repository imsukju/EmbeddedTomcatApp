<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Success Page</title>
</head>
<body>
    <h2>Welcome</h2>
    <!-- 세션에서 로그인된 사용자 정보를 EL을 통해 출력 -->
	
    <c:choose>
        <c:when test="${not empty loggedInUser}">
            <p>환영합니다, ${loggedInUser.userName}님!</p>
        </c:when>
        <c:otherwise>
            <p>로그인 정보가 없습니다.</p>
        </c:otherwise>
    </c:choose>
	<a href="/CreatBank">계좌번호 등록</a>
	<a href="/BankSystem">Use Bank System</a>
</body>
</html>
