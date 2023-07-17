package com.yedam.web.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.web.board.mapper.BoardMapper;
import com.yedam.web.board.service.BoardService;
import com.yedam.web.board.service.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> selectBoardList() {
		return boardMapper.selectBoardList();
	}

	@Override
	public BoardVO selectBoard(BoardVO boardVO) {
		return boardMapper.selectBoard(boardVO);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		int result = boardMapper.insertBoard(boardVO);
		if (result > 0) {
			return boardVO.getBno(); 
		} else {
			return -1;
		}
		
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		int result = boardMapper.updateBoard(boardVO);
		if (result > 0) {
			return boardVO.getBno();
		} else {
			return -1;
		}
		
	}

	@Override
	public int deleteBoard(int boardNo) {
		int result = boardMapper.deleteBoard(boardNo);
		if (result > 0) {
			return boardNo;
		} else {
			return -1;
		}
	}

}