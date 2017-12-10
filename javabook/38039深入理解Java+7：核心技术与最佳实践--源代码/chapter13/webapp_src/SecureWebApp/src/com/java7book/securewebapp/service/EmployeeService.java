package com.java7book.securewebapp.service;

import com.java7book.securewebapp.DeclaredPermission;

public interface EmployeeService {
	@DeclaredPermission(name="employee.info", actions="read")
	Employee read(String employeeId);
}
