<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>송금 페이지</title>
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
    <h1>송금하실 계좌번호를 선택하세요.</h1>
    
    <form action="${pageContext.request.contextPath}/processTransfer" method="POST">
        <label for="bank">계좌 선택:</label>
        <select id="bank" name="bankId" required>
            <c:forEach var="bank" items="${banks}" >
                <option value="${bank.bankid}">Bank Name : ${bank.bankName} || account: ${bank.bankAccount}</option>
            </c:forEach>
        </select>
		<br>

 
        
        <label for="amount">송금 금액:</label>
        <input type="text" id="amount" name="amount" required />
        
        <br>
		<h1>어디로 돈을 보낼까요?</h1>
		<label for="bank">은행 선택:</label>
		<select id="options" name="bankName" required>
		    <option value="Abank">a은행</option>
		    <option value="Bbank">b은행</option>
		    <option value="Cbank">c은행</option>
		    <option value="Dbank">d은행</option>
		</select>
		<label for="account">받으실분의 계좌:</label>
		<input type="text" id="account" name="bankAccount"><br>
		
		<br>
		
        
        <input type="submit" value="송금하기">
    </form>
</body>
</html>
