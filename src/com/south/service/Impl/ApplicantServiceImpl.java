package com.south.service.Impl;

import com.south.dao.ApplicantDao;
import com.south.dao.Impl.ApplicantDaoImpl;
import com.south.pojo.Applicant;
import com.south.service.ApplicantService;

import java.util.List;

public class ApplicantServiceImpl implements ApplicantService {
	private ApplicantDao applicantDao = new ApplicantDaoImpl();
	@Override
	public void saveApplicant(Applicant applicant) {
		applicantDao.saveApplicant(applicant);	
	}
	@Override
	public void deleteApplicant(String id) {
		applicantDao.deleteApplicant(id);
	}
	@Override
	public void updateApplicant(String id) {
		applicantDao.updateApplicant(id);	
	}
	@Override
	public List findApplicantByIsstock(String isstock) {
		return applicantDao.findApplicantByIsstock(isstock);
	}
	@Override
	public List findAllApplicants() {
		return applicantDao.findAllApplicants();
	}
	@Override
	public Applicant findApplicantById(String id) {
		return applicantDao.findApplicantById(id);
	}

}
