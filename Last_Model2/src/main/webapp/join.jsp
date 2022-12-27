<%@page import="java.sql.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/css.css">

</head>
<body>
	<div id="wrap" class="card-body">
        <header>
            <h1>회원가입</h1>
        </header>
        <section>
        	<form action="JoinCtrl.do" method="post">
                <table class="table table-bordered">
                    <tr>
                        <td>아이디</td>
                        <td align="center">
                        	<input type="text" name="id" size="40" placeholder="id 입력" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td align="center">
                        	<input type="password" name="pw" placeholder="비밀번호 입력" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                    	<td>비밀번호 확인</td>
                    	<td align="center">
                    		<input type="password" name="pw2" placeholder="비밀번호 확인" class="form-control" />
                    	</td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td align="center">
                        	<input type="text" name="name" size="40" placeholder="이름" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                    	<td align="center" colspan="2">
                    		<input type="submit" value="회원가입" class="btn btn-primary" /> &nbsp;
                    		<input type="reset" value="재입력" class="btn btn-primary" />&nbsp;
                    		<a href="./index.jsp"><input type="button" value="메인" class="btn btn-primary" /></a>
                    	</td>
                    </tr>
                </table>
            </form> 
        </section>
    </div>
</body>
</html>