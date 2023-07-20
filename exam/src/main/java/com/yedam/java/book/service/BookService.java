package com.yedam.java.book.service;

import java.util.List;

public interface BookService {
	
	// 도서 목록 조회
	public List<BookVO> getBookAll();

	// 도서 번호 가져오기
	public BookVO getBookNo();
	
	// 도서 등록
	public int insertBookInfo(BookVO bookVO);
}
