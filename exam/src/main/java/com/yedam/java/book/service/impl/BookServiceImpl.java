package com.yedam.java.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.BookMapper;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookMapper bookMapper;

	@Override
	public List<BookVO> getBookAll() {
		return bookMapper.selectBookList();
	}
	
	@Override
	public BookVO getBookNo() {
		return bookMapper.selectBookNo();
	}

	@Override
	public int insertBookInfo(BookVO bookVO) {
		return bookMapper.insertBook(bookVO);
	}



}
