package com.south.service;

import com.south.pojo.Applicant;

import java.util.List;

public interface ApplicantService {
	void saveApplicant(Applicant applicant);
	void deleteApplicant(String id);
	void updateApplicant(String id);
	List findAllApplicants();
	Applicant findApplicantById(String id);
	List findApplicantByIsstock(String isstock);
}
