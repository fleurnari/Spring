<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
<h4>도서 등록</h4>

<form name="insertForm" action="bookInsert" method="post">
	<div>도서번호<input type="number" name="bookNo" value="${bookVO.bookNo}"></div>	
	<div>도서명<input type="text" name="bookName"></div>
	<div>도서표지<input width="300px" type="text" name="bookCoverimg"></div>
	<div>출판일자<input type="text" name="bookDate"></div>
	<div>금액<input type="number" name="bookPrice"></div>
	<div>출판사<input type="text" name="bookPublisher"></div>
	<div>도서소개<textarea rows="10" cols="5" name="bookInfo"></textarea></div>
	<button type="submit">등록</button>
	<button type="button" onclick="location.href='bookList'">조회</button>
</form>
<script>

	
	document.querySelector('form[name="insertForm"]')
		.addEventListener('submit', function(e){
			e.preventDefault();
		
			let bookName = document.getElementsByName('bookName')[0];
			
			if (bookName.value == ''){
				alert("도서명이 입력 되지 않았습니다.");
				bookName.focus();
				return;
			}
			alert(`${message}`);
			insertForm.submit();
		});

</script>
</body>
</html>