<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원가입</title>
<style>
	table, th, td{
		border : 1px solid black;
	}
</style>
</head>
<body>
        <form action="insertMember.do" method="post">
            이메일 : <input name = "email" type="text">
            이름 : <input name = "member_name" type="text">
            패스워드 : <input name = "password" type="password">
            닉네임 : <input name = "member_nic" type="text">
            <button type="submit">회원가입</button>
        </form>
</body>
</html>