package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Ex05ApplicationTests {
	@Autowired
	EmpMapper empMapper;
	
	@Test
	void selectAllTest() {
		List<EmpVO> empList = empMapper.selectAllEmp();
		assertTrue(!empList.isEmpty());
	}
	
	@Autowired
	StringEncryptor jasyptStringEncryptor;
	
	@Test
	void encryptTest() {
		String[] dataList = {
							 "oracle.jdbc.OracleDriver"
							  ,"jdbc:oracle:thin:@127.0.0.1:1521/xe"
							  ,"hr"
							  ,"1234"
							};
		for(String data : dataList) {
			String encData = jasyptStringEncryptor.encrypt(data);
			System.out.println(encData);
		}
	}

}
