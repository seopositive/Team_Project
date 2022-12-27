<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty logid }">
	<c:redirect url="login.jsp" />
</c:if>
	
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 목록</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/css.css">
</head>
<body>
    <div id="wrap" class="card-body">
    	<aside>
    		${logid }님 접속중!! &nbsp;&nbsp;
    		<a href="logoutCtrl"><button class="btn btn-secondary">로그아웃</button></a>
    	</aside>    
        <header>
            <h1>글목록 보기</h1>
        </header>
        <section>
			<table class="table table-bordered">
				<tr>
					<td width="100">번호</td>
					<td width="200">제목</td>
					<td width="150">작성자</td>
					<td width="150">등록일</td>
					<td width="100">조회수</td>
				</tr>
				<c:forEach var="board" items="${boardList }">
					<tr>
						<td width="100">${board.seq }</td>
						<td width="100"><a href="OneBoardCtrl.do?num=${board.seq }">${board.title }</a></td>
						<td width="200">${board.nickname }</td>
						<td width="150">${board.regdate }</td>
						<td width="150">${board.cnt }</td>
					</tr>
				</c:forEach>
			</table>
            <a href="addBoard.jsp"><input type="button" value="글등록" class="btn btn-primary"></a>
        </section>
    </div>
</body>
</html>