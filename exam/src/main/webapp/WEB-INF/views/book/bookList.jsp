<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록</title>
<style type="text/css">
	table, th, td {
	border: 1px solid black;
	}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th align="center">도서번호</th>
				<th align="center">도서명</th>
				<th align="center">표지</th>
				<th align="center">출판일자</th>
				<th align="center">금액</th>
				<th align="center">출판사</th>
				<th align="center">도서소개</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td>${book.bookNo}</td>
					<td>${book.bookName}</td>
					<td>
						<img width="150px" src='<c:url value="/resources/images/${book.bookCoverimg}" />'>
					</td>
					<td>
						<fmt:formatDate value="${book.bookDate}" pattern="yyyy/MM/dd"/>
					</td>
					<td>
						<fmt:formatNumber value="${book.bookPrice}" pattern="#,###" />
					</td>
					<td>${book.bookPublisher}</td>
					<td>${book.bookInfo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>