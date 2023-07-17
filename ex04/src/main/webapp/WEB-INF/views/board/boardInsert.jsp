<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<div align="center">
		<form name="insertForm" action="boardInsert" method="post">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="10" cols="50" name="contents"></textarea></td>
				</tr>
				<tr>
					<th>첨부 이미지</th>
					<td><input type="text" name="image"></td>
				</tr>
				<tr>
					<th>작성일자</th>
					<td><input type="date" name="regdate"></td>
				</tr>
			</table>
			<button type="submit">등록</button>
			<button type="reset">취소</button>
		</form>
	</div>
	<script>
		document.querySelector('form[name="insertForm"]')
			 	.addEventListener('submit', function(e){
			 		e.preventDefault();
			 		
			 		let title = document.getElementsByName('title')[0];
			 		let writer = document.getElementsByName('writer')[0];
			 		
			 		if (title.value == '') {
			 			alert("제목을 입력해 주세요.");
			 			title.focus();
			 			return;
			 		}
			 		
			 		if (writer.value == '') {
			 			alert("작성자를 입력해 주세요.");
			 			writer.focus();
			 			return;
			 		}
			 		
			 		insertForm.submit();
			 		
			 	});
	</script>
</body>
</html>