package com.yedam.java.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	// 도서 목록 조회
	@GetMapping("/bookList")
	public String selectBookList(Model model) {
		model.addAttribute("bookList", bookService.getBookAll());
		return "book/bookList";
	}
	
	// 도서 정보 등록 폼
	@GetMapping("/bookInsert")
	public String insertBookForm(Model model) {
		BookVO findVO = bookService.getBookNo();
		model.addAttribute("bookVO", findVO);
		return "book/bookInsert";
	}
	
	// 도서 정보 등록 프로세스
	@PostMapping("/bookInsert")
	public String insertBookProcess(BookVO bookVO, RedirectAttributes rttr) {
		int result = bookService.insertBookInfo(bookVO);
		String message = null;
		
		if (result > 0) {
			message = "도서 등록이 완료 되었습니다."; 
		} else {
			message = "도서 등록에 실패 했습니다.";
		}
		
		rttr.addFlashAttribute("message", message);
		return "redirect:bookList";
	}
	
	
}
