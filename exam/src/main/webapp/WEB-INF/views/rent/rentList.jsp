<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서별 대여매출현황</title>
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
				<th align="center">대여총계</th>
				<th align="center">대여횟수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${rentList}" var="rent">
				<tr>
					<td>${rent.bookNo}</td>
					<td>${rent.bookName}</td>
					<td>${rent.rentTotal}</td>
					<td>${rent.rentCount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>