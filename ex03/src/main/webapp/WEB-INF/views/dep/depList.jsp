<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 조회</title>
<style type="text/css">
	table, th, td {
		border : 1px solid black;
	}
</style>
</head>
<body>
	<button type="button" onclick="location.href='depInsert'">등록</button>
	<table>
		<thead>
			<tr>
				<th>department_id</th>
				<th>department_name</th>
				<th>manager_id</th>
				<th>location_id</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${depList}" var="dep">
				<tr onclick="location.href='depInfo?departmentId=${dep.departmentId}'">
					<td>${dep.departmentId}</td>
					<td>${dep.departmentName}</td>
					<td>${dep.managerId}</td>
					<td>${dep.locationId}</td>
					<td><button type="button">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		printMessage(`${result}`);
	
		function printMessage(msg){
			if (msg == null || msg == '') return;
			alert(msg);
		}
	</script>
</body>
</html>