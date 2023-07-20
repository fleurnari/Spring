package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookVO;

public interface BookMapper {
	
	// 도서 목록 조회
	public List<BookVO> selectBookList();
	
	// 도서 번호 가져오기
	public BookVO selectBookNo();
	
	// 도서 정보 등록
	public int insertBook(BookVO bookVO);
}
