package com.yedam.web.board.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.web.board.service.BoardVO;

public interface BoardMapper {

	// 전체 조회
	public List<BoardVO> selectBoardList();

	// 단건 조회
	public BoardVO selectBoard(BoardVO boardVO);
	
	// 등록
	// 1) 게시글 번호 자동 생성
	// 2) 테이블 참조해서 필수값 / 옵션값 구분
	public int insertBoard(BoardVO boardVO);
	
	// 수정
	// 1) 수정 대상 : 제목, 내용, 이미지
	// 2) updatedate : 수정날짜
	public int updateBoard(BoardVO boardVO);
	
	// 삭제
	public int deleteBoard(int boardNo);
	
}
