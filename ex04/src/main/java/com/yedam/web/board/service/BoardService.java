package com.yedam.web.board.service;

import java.util.List;

public interface BoardService {
	
	// 전체 조회
	public List<BoardVO> selectBoardList();
	
	// 단건 조회
	public BoardVO selectBoard(BoardVO boardVO);
	
	// 등록 - 등록된 글 번호 반환 / 실패 : -1
	public int insertBoard(BoardVO boardVO);
	
	// 수정 - 수정된 글 번호 반환 / 실패 : -1
	public int updateBoard(BoardVO boardVO);
	
	// 삭제 - 삭제된 글 번호 반환 / 실패 : -1
	public int deleteBoard(int boardNo);

}