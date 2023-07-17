<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<div align="center">
	<button type="button" onclick="location.href='boardInsert'">등록</button>
	<table>
		<thead>
			<tr>
				<th align="center" width="150">번호</th>
				<th align="center" width="150">제목</th>
				<th align="center" width="150">작성자</th>
				<th align="center" width="150">작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList}" var="board">
				<tr onclick="location.href='boardInfo?bno=${board.bno}'">
					<td>${board.bno}</td>
					<td>${board.title}</td>
					<td>${board.writer}</td>
					<td>
						<fmt:formatDate value="${board.regdate}" pattern="yyyy년MM월dd일"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>