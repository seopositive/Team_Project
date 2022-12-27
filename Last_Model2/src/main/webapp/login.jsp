<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">   
<link rel="stylesheet" href="css/css.css">
<link rel="stylesheet" href="css/reset.css"> 
</head>
<body>
    <div id="wrap">
        <header>
            <h1>로그인</h1>
        </header>
        <section>
            <form method="post" action="loginCtrl">
                <table class="table table-bordered">
                    <tr>
                        <td>아이디</td>
                        <td><input type="text" name="id"></td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td><input type="password" name="pw"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="로그인" class="btn btn-primary">
                            <input type="reset" value="취소" class="btn btn-primary">
                        </td>
                    </tr>
                </table>
            </form>
        </section>
    </div>
</body>