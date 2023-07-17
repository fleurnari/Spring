<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<div align="center">
		<form name="updateForm">
			<table>
				<tr>
					<th>번호</th>
					<td><input type="text" name="bno" value="${boardInfo.bno}" readonly="readonly"></td>
				</tr>
				<tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" value="${boardInfo.title}"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer" value="${boardInfo.writer}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="10" cols="50" name="contents">${boardInfo.contents}</textarea></td>
				</tr>
				<tr>
					<th>첨부 이미지</th>
					<td><input type="text" name="image" value="${boardInfo.image}"></td>
				</tr>
				<tr>
					<th>수정일자</th>
					<td><input type="date" name="updatedate" value='<fmt:formatDate value="${boardInfo.updatedate}" pattern="yyyy-MM-dd"/>'>
						 </td>
				</tr>
			</table>
			<button type="submit">수정</button>
			<button type="button" onclick="location.href='boardInfo?bno={boardInfo.bno}'">취소</button>
		</form>
	</div>
	<script>
		
		$('form').on('submit', function(e){
			
			let objData = serializeObject();
			
			$.ajax({
				url : 'boardUpdate',
				method : 'POST',
				data : objData
			})
			.done(data => {
				if (data.result){
					let message = data.boardInfo.bno + "번 게시물 수정 완료";
					alert(message);
				} else {
					alert("수정 실패");
				}
			})
			.fail(reject => console.log(reject));
			
			return false;
		});
		
		function serializeObject(){
			let formData = $('form').serializeArray();
			
			let formObject = {};
			$.each(formData, function(idx, obj){
				let field = obj.name;
				let val = obj.value;
				
				formObject[field] = val;
			});
			
			return formObject;
		}

	</script>
</body>
</html>