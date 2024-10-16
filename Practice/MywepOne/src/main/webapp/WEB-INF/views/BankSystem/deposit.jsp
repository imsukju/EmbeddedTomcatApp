<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>입금 페이지</title>
    <style>
        /* 레이블과 입력 필드 간의 간격을 설정 */
        label {
            display: inline-block;
            width: 100px;
        }
        
        /* 폼의 전반적인 스타일을 설정 */
        form {
            margin: 20px;
        }

        /* 필드 간 간격 */
        input, select {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <h1>입금 기능</h1>
    
    <form action="${pageContext.request.contextPath}/processDeposit" method="POST">
        <label for="bank">은행 선택:</label>
        <select id="bank" name="bankId" required>
            <c:forEach var="bank" items="${banks}">
                <option value="${bank.bankid}">Bank Name : ${bank.bankName} || account: ${bank.bankAccount}</option>
            </c:forEach>
        </select>
		<br>

 
        
        <label for="amount">입금 금액:</label>
        <input type="text" id="amount" name="amount" required />
        
        <br><br>
        
        <input type="submit" value="입금">
    </form>
</body>
</html>
