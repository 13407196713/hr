package com.south.dao;

import com.south.pojo.Salary;

import java.util.List;

public interface SalaryDao {
	List findAllSalaries();
	void saveSalary(Salary salary);
	void updateSalary(Salary salary);
	Salary findSalaryById(String id);
	void deleteSalary(String id);
}
