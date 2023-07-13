package com.yedam.app.dep.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.dep.service.DepService;
import com.yedam.app.dep.service.DepVO;

@Controller
public class DepController {

	@Autowired
	DepService depService;
	
	// 전체 조회
	@GetMapping("/depList")
	public String getDepAllList(Model model) {
		model.addAttribute("depList", depService.getDepAll());
		return "dep/depList";
	}
	
	// 단건 조회
	@GetMapping("/depInfo")
	public String getDepInfo(DepVO depVO, Model model) {
		DepVO findVO = depService.getDep(depVO);
		model.addAttribute("depInfo", findVO);
		return "dep/depInfo";
	}
	
	// 등록 - Form
	@GetMapping("/depInsert")
	public String depInsertForm() {
		return "dep/depInsert";
	}
	
	// 등록 - Process
	@PostMapping("/depInsert")
	public String depInsertProcess(DepVO depVO, RedirectAttributes rttr) {
		int depId = depService.insertDep(depVO);
		String result = null;
		String uri = null;
		if (depId == -1) {
			result = "등록 실패";
			uri = "deptList";
		} else {
			result = "등록 완료. 부서 번호 : " + depId;
			uri = "depInfo?departmentId=" + depId;
		}
		
		rttr.addFlashAttribute("result", result);
		//return "redirect:depInfo?departmentId=" + depId;
		return "redirect:" + uri;
	}
	
	// 수정
	@PostMapping("/depUpdate")
	@ResponseBody
	public Map<String, String> depUpdateProccess(@RequestBody DepVO depVO){
		return depService.updateDep(depVO);
	}
	
	// 삭제
	@PostMapping("/depDelete")
	@ResponseBody
	public String depDeleteProcess(@RequestParam int departmentId) {
		Map<String, String> map = depService.deleteDep(departmentId);
		return map.get("결과");
	}
	
}
