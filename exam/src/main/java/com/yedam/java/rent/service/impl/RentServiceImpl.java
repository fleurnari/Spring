package com.yedam.java.rent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.rent.mapper.RentMapper;
import com.yedam.java.rent.service.RentService;
import com.yedam.java.rent.service.RentVO;

@Service
public class RentServiceImpl implements RentService{
	
	@Autowired
	RentMapper rentMapper;

	@Override
	public List<RentVO> getAllRent() {
		return rentMapper.selectRentList();
	}

}
