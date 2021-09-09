package com.south.service.Impl;

import com.south.dao.Impl.SalaryDaoImpl;
import com.south.dao.SalaryDao;
import com.south.pojo.Salary;
import com.south.service.SalaryService;

import java.util.List;

public class SalaryServiceImpl implements SalaryService{
	private SalaryDao salaryDao = new SalaryDaoImpl();

	@Override
	public void saveSalary(Salary salary) {
		salaryDao.saveSalary(salary);
	}
	@Override
	public void updateSalary(Salary salary) {
		salaryDao.updateSalary(salary);	
	}
	@Override
	public void delete(String id) {
		salaryDao.deleteSalary(id);	
	}
	@Override
	public Salary findSalaryById(String id) {
		return salaryDao. findSalaryById(id);
	}
	@Override
	public List findAllSalaries() {
		return salaryDao.findAllSalaries();
	}
}
