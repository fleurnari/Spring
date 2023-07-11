package com.yedam.app.dep.servicer;

import lombok.Data;

@Data
public class DepVO {
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
}
