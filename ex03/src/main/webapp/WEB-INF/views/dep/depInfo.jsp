<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<form>
		<div>
			<label>department_id : <input type="number" name="departmentId" value="${depInfo.departmentId}" readonly> </label>
		</div>
		<div>
			<label>department_name : <input type="text" name="departmentName" value="${depInfo.departmentName}"> </label>
		</div>
		<div>
			<label>manager_id : <input type="number" name="managerId" value="${depInfo.managerId}"> </label>
		</div>
		<div>
			<label>location_id : <input type="number" name="locationId" value="${depInfo.locationId}"> </label>
		</div>
		<button type="submit">수정</button>
		<button type="button" onclick="location.href='depList'">목록</button>
	</form>
	<script>
		printMessage(`${result}`);
		
		function printMessage(msg){
			if (msg == null || msg == '') return;
			alert(msg);
		}
	
		$('form').on('submit', ajaxUpdateDep);
		
		function serializeObject(){
			let formData = $('form').serializeArray();
			
			let objectData = {};
			
			$.each(formData, function(idx, obj){
				objectData[obj.name] = obj.value;
			});
			
			return objectData;
		}
		
		function ajaxUpdateDep(e){
			e.preventDefault();
			
			$.ajax({
				url : 'depUpdate',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(serializeObject())
			})
			.done( data => {
				if (data != null && data['결과'] == 'Success') {
					alert('부서 번호 : ' + data['부서번호'] + '의 정보 변경');
				} else {
					alert('부서 정보 수정 실패');
				}
			})
			.fail( reject => console.log(reject));
		};
	</script>
</body>
</html>