<%@ page import="poly.util.CmmUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    String member_name = CmmUtil.nvl((String) session.getAttribute("SS_MEMBER_NIC"));
    // 그럴수있음 그 뭐지 게시판은 내꺼 noticemapper - inoticemapper - inoticeservice - noticeservice - noticecontroller
    // 컨트롤러에 session.addAttribute 해서 키 벨류 값 추가하면 session 값은 로그인이 유지되는 동안 계속 가지고있어서 model로 하나하나 넘기지 않아도 jsp 어디서든 로그인만하면
    // session에 담겨있는 데이터 쓸 수 있음
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>lounge</title>
<style>
	table, th, td{
		border : 1px solid black;
	}
</style>
</head>
<body>

<h2><%=member_name%>님 환영합니다.</h2>
<hr>
<a href="/Board/boardList.do">목록</a>


</body>
</html>