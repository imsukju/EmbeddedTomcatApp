<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>계좌 생성</title>
</head>
<body>
    <h2>Create New Account</h2>
    <form action="/bank/addaccount" method="post">
		
		<label for="options">옵션 선택:</label>
		<select id="options" name="bankName">
		    <option value="Abank">a은행</option>
		    <option value="Bbank">b은행</option>
		    <option value="Cbank">c은행</option>
		    <option value="Dbank">d은행</option>
		</select>
        <label for="bankaccount">계좌번호:</label>
        <input type="text" id="bankAccount" name="bankAccount"><br>
		
		<c:choose>
		        <c:when test="${not empty loggedInUser}">
		            <p>유저이름 : ${loggedInUser.userName}</p>
		        </c:when>
		        <c:otherwise>
		            <p>로그인 정보가 없습니다.</p>
		        </c:otherwise>
		    </c:choose>
		<button type="submit">등록하기</button>
    </form>
    <br>

</body>
</html>
