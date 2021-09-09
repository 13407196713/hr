package com.south.service;

import com.south.pojo.Salary;

import java.util.List;

public interface SalaryService {
	List findAllSalaries();
	void saveSalary(Salary salary);
	void updateSalary(Salary salary);
	Salary findSalaryById(String id);
	void delete(String id);
}
