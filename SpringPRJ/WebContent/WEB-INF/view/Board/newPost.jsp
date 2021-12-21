<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="poly.dto.BoardDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="poly.util.CmmUtil" %>
<%
    List<BoardDTO> rList = (List<BoardDTO>) request.getAttribute("rList");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>새 글 등록</title>
<style>
	table, th, td{
		border : 1px solid black;
	}
</style>
</head>
<body>
<div style="margin: auto; width: 800px;">
    <h1 style="text-align: center;">새 글 등록</h1>
    <form action="/Board/doPost.do" method="post">
        <div>제목</div>
        <div>
            <input type="text" name="title" style="width: 800px;" required>
        </div>

        <br>

        <div>내용</div>
        <div>
				<textarea name="contents" style="width: 800px; height: 500px;"
                          required></textarea>
        </div>
        <div style="width: 800px; text-align: right; margin-top: 5px;">
            <input type="submit" value="제출">
        </div>
    </form>
</div>


</body>
</html>