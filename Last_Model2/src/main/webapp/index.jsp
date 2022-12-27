<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL 사용 위해 선언 -->
<%
	request.setCharacterEncoding("utf-8");
%>        
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>홈 화면</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">   
<link rel="stylesheet" href="css/css.css">
<link rel="stylesheet" href="css/reset.css"> 
</head>
<body>
    <div id="wrap" class="card-body">
		<header>
			<h1>시작페이지</h1>
	
			<c:set var = "id" value="${logid }"/>
			
			<c:if test='${empty id }'>
				  <div>
		              <a href="./login.jsp">로그인</a>
		              <a href="BoardListCtrl.do">글목록</a>
		              <a href="./join.jsp">회원가입</a>
		          </div>
			</c:if>
	
			<c:if test='${not empty id}' >
				<div>
		            <a href="logoutCtrl">로그아웃</a>
		            <a href="BoardListCtrl.do">글목록</a>	  
		            <a href="./addBoard.jsp">글쓰기</a>
		        </div>
			</c:if>     
		</header>
	</div>
</body>
</body>
</html>