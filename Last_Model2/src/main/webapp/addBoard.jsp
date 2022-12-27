<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL 사용 위해 선언 -->

<c:if test="${empty logid }">
	<c:redirect url="login.jsp" />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 게시판</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">   
<link rel="stylesheet" href="css/css.css">
<link rel="stylesheet" href="css/reset.css"> 
</head>
<body>
	<div id="wrap" class="card-body">
		<aside>
			<a href="logoutCtrl">
				<button class="btn btn-secondary">로그아웃</button>
			</a>
		</aside>
        <header>
            <h1>새글 등록</h1>
        </header>
        <section>
            <form method="post" action="addBoardCtrl.do">
                <table class="table table-bordered">
                    <tr>
                        <td>제목</td>
                        <td><input type="text" name="title" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>작성자</td>
                        <td><input type="text" name="nickname" size="10" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td>
							<textarea name="content" cols="40" rows="10" class="form-control"></textarea>
						</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="새글등록" class="btn btn-primary">
                        </td>
                    </tr>
                </table>
            </form>
        </section>
    </div>
</body>
</html>