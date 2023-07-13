package com.yedam.app.dep.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dep.mapper.DepMapper;
import com.yedam.app.dep.service.DepService;
import com.yedam.app.dep.service.DepVO;

@Service
public class DepServiceImpl implements DepService {
	
	@Autowired
	DepMapper depMapper;

	@Override
	public List<DepVO> getDepAll() {
		return depMapper.selectDepAllList();
	}

	@Override
	public DepVO getDep(DepVO depVO) {
		return depMapper.selectDepInfo(depVO);
	}

	@Override
	public int insertDep(DepVO depVO) {
		int result = depMapper.insertDepInfo(depVO);
		if (result == 1) {
			return depVO.getDepartmentId();
		} else {
			return -1;
		}
	}

	@Override
	public Map<String, String> updateDep(DepVO depVO) {
		Map<String, String> map = new HashMap<>();
		
		map.put("부서번호", String.valueOf(depVO.getDepartmentId()));
		
		int result = depMapper.updateDepInfo(depVO);
		
		if (result > 0) {
			map.put("결과", "Success");
		} else {
			map.put("결과", "Fail");
		}
		
		return map;
	}

	@Override
	public Map<String, String> deleteDep(int depId) {
		Map<String, String> map = new HashMap<>();
		
		map.put("부서번호", String.valueOf(depId));
		
		int result = depMapper.deleteDepInfo(depId);
		
		if (result == 1) {
			map.put("결과", "Success");
		} else {
			map.put("결과", "Fail");
		}
		
		return map;
	}

}
