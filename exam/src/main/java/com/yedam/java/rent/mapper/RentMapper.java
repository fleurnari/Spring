package com.yedam.java.rent.mapper;

import java.util.List;

import com.yedam.java.rent.service.RentVO;

public interface RentMapper {
	
	// 도서 대여 현황 조회
	public List<RentVO> selectRentList();

}
