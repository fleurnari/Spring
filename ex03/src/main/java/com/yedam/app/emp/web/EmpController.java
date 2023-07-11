package com.yedam.app.emp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {

	@Autowired
	EmpService empService;
	
	// 조회 (데이터, 일반 페이지) -> GET
	// 등록, 수정, 삭제 	   -> POST
	
	// 전체 조회
	@GetMapping("/empList")
	public String getEmpAllList(Model model) {
		model.addAttribute("empList", empService.getEmpAll());
		return "emp/empList";
	}
	
	// 단건 조회
	@GetMapping("/empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.getEmp(empVO);
		model.addAttribute("empInfo", findVO);
		return "emp/empInfo";
	}
	
	// 등록 - Form
	@GetMapping("/empInsert")
	public String empInsertForm() {
		return "emp/empInsert";
	}
	
	// 등록 - Process
	@PostMapping("/empInsert")
	public String empInsertProcess(EmpVO empVO, RedirectAttributes rttr) {
		int empId = empService.insertEmp(empVO);
		String result = null;
		if (empId == -1) {
			result = "등록에 실패 했습니다.";
		} else {
			result = "정상적으로 등록 되었습니다."
					+ "\n 등록된 사원의 사번은 " + empId + "입니다.";
		}
		
		rttr.addFlashAttribute("result", result);
		return "redirect:empList";
	}
	
	// 수정 - Process
	// 1) Client - JSON -> Server : @RequestBody
	// 2) Server - JSON -> Client : @ResponseBody
	@PostMapping("/empUpdate")
	@ResponseBody
	public Map<String, String> empUpdateProcess(@RequestBody EmpVO empVO){
		return empService.updateEmp(empVO); 
	}
	
}
