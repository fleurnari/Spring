package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.dep.mapper.DepMapper;
import com.yedam.app.dep.servicer.DepVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/database-context.xml")

public class DepMapperClient {
	@Autowired
	DepMapper depMapper;
	
	@Test
	public void selectAllDep() {
		// 전체 조회
		List<DepVO> depList = depMapper.selectDepAllList();
		assertTrue(!depList.isEmpty());
	}
	
	@Test
	public void selectDepInfo() {
		// 단건 조회
		DepVO depVO = new DepVO();
		depVO.setDepartmentId(80);
		
		DepVO findVO = depMapper.selectDepInfo(depVO);
		assertEquals(findVO.getDepartmentName(), "Sales");
	}
	
	@Test
	public void insertDepInfo() {
		// 등록
		DepVO depVO = new DepVO();
		depVO.setDepartmentName("Sleep");
		depVO.setManagerId(1000);
		depVO.setLocationId(1800);
		
		depMapper.insertDepInfo(depVO);
		assertNotEquals(depVO.getDepartmentId(), 0);
	}
	
	
}
