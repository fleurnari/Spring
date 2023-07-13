package com.yedam.app.dep.service;

import lombok.Data;

@Data
public class DepVO {
	private int departmentId;
	private String departmentName;
	private Integer managerId;
	private Integer locationId;
}
