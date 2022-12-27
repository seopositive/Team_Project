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
    <title>글 수정</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/css.css">
</head>
<body>
    <div id="wrap" class="card-body">
    	<aside>
    		${logid }님
    		<a href="logoutCtrl"><button class="btn btn-secondary">로그아웃</button></a>
    	</aside>
        <header>
            <h1>글 수정</h1>
        </header>
        <section>
            <form method="post" action="UpdateBoardCtrl">
            	<!-- hidden으로 값 넘겨줌 -->
            	<input type="hidden" name="seq" value="${board.seq }">
                <table class="table table-bordered">
                    <tr>
                        <td>제목</td>
                        <td>
                        	<input type="text" name="title" class="form-control" value="${board.title }">
                        </td>
                    </tr>
                    <tr>
                        <td>작성자</td>
                        <td>
                        	${board.nickname }
                        </td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td>
                        	<textarea name="content" cols="40" rows="10" class="form-control">${board.content }</textarea>
						</td>
                    </tr>
                    <tr>
                        <td>등록일</td>
                        <td>
                        	${board.regdate }
                        </td>
                    </tr>
                    <tr>
                        <td>조회수</td>
                        <td>
                        	${board.cnt }
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><br>
                            <input type="submit" value="글수정" class="btn btn-primary"> &nbsp;&nbsp;
                            <a href="addBoard.jsp"><input type="button" value="글등록" class="btn btn-primary"></a> &nbsp;&nbsp;
                            <a href="DeleteBoard.do?num=${board.seq }"><input type="button" value="글삭제" class="btn btn-primary"></a> &nbsp;&nbsp;
                            <a href="BoardListCtrl.do"><input type="button" value="글목록" class="btn btn-primary"></a> &nbsp;&nbsp;
                        </td>
                    </tr>
                </table>
            </form>            
        </section>
    </div>
</body>
</html>