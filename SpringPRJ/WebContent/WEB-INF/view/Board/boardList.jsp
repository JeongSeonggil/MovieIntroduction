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
<title>BoardList</title>
<style>
	table, th, td{
		border : 1px solid black;
	}
</style>
</head>
<body>
<div style="margin: auto; width: 800px;">

    <table border="1" style="width: 100%">

        <thead>
        <tr>
            <th>글 번호</th>
            <th>제목</th>
            <th>게시일</th>
            <th>게시자</th>
        </tr>
        </thead>

        <tbody>
        <%
            for (BoardDTO e : rList) {
        %>
        <tr>
            <td><%=CmmUtil.nvl(e.getNOTICE_SEQ())%></td>
            <td style="size: 500px"><a href="/board/boardDetail.do?no=<%=e.getNOTICE_SEQ() %>"><%=CmmUtil.nvl(e.getTITLE()) %></a></td>
            <td><%=CmmUtil.nvl(e.getREG_DT())%></td>
            <td><%=CmmUtil.nvl(e.getUSER_NIC())%></td>
        </tr>
        <%
            }
        %>
        </tbody>

    </table>


    <div style="width: 100%; text-align: right; margin-top: 5px;">
        <button onclick="location.href='/Board/newPost.do'">새 글</button>
    </div>

</div>

</body>
</html>