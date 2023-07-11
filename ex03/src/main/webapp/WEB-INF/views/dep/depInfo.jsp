<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 조회</title>
</head>
<body>
	<form>
		<div>
			<label>department_id : <input type="number" name="" value="${depInfo.departmentId}"> </label>
		</div>
		<div>
			<label>department_name : <input type="text" name="" value="${depInfo.departmentName}"> </label>
		</div>
		<div>
			<label>manager_id : <input type="number" name="" value="${depInfo.managerId}"> </label>
		</div>
		<div>
			<label>location_id : <input type="number" name="" value="${depInfo.locationId}"> </label>
		</div>
		<button type="submit">수정</button>
		<button type="button">취소</button>
	</form>
</body>
</html>