package com.yedam.java.rent.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.java.rent.service.RentService;

@Controller
public class RentController {

	@Autowired
	RentService rentService;
	
	@GetMapping("/rentList")
	public String selectRentList(Model model) {
		model.addAttribute("rentList", rentService.getAllRent());
		return "rent/rentList";
	}
	
}
