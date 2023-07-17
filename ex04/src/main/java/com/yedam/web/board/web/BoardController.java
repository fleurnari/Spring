package com.yedam.web.board.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.web.board.service.BoardService;
import com.yedam.web.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	// 전체 조회
	@GetMapping("/boardList")
	public String selectBoardList(Model model) {
		model.addAttribute("boardList", boardService.selectBoardList());
		return "board/boardList";
	}
	
	// 단건 조회
	@GetMapping("/boardInfo")
	public String selectBoard(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.selectBoard(boardVO);
		model.addAttribute("boardInfo", findVO);
		return "board/boardInfo";
	}
	
	// 등록 Form
	@GetMapping("/boardInsert")
	public String insertBoardForm() {
		return "board/boardInsert";
	}
	
	// 등록 Process
	@PostMapping("/boardInsert")
	public String insertBoardProcess(BoardVO boardVO) {
		boardService.insertBoard(boardVO);
		return "redirect:boardList";
	}
	
	// 수정 Form
	@GetMapping("/boardUpdate")
	public String updateBoardForm(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.selectBoard(boardVO);
		model.addAttribute("boardInfo", findVO);
		return "board/boardUpdate";
	}
	
	// 수정 Process
	@PostMapping("/boardUpdate")
	@ResponseBody
	public Map<String, Object> updateBoardProcess(BoardVO boardVO) {
		boolean result = false;
	
		int boardNo = boardService.updateBoard(boardVO);
		
		if (boardNo > -1) {
			result = true;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", result);
		map.put("boardInfo", boardVO);
		return map;
	}
	
	
	// 삭제
	@GetMapping("/boardDelete")
	public String deleteBoard(@RequestParam(name = "bno", defaultValue = "0") int boardNo) {
		boardService.deleteBoard(boardNo);
		return "redirect:boardList";
	}
	
	
}
