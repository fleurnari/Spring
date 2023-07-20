package com.yedam.java.rent.service;

import java.util.List;

public interface RentService {
	
	// 도서 대여 현황 조회
	public List<RentVO> getAllRent();

}
