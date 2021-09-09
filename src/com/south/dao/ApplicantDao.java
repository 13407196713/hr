package com.south.dao;

import com.south.pojo.Applicant;

import java.util.List;

public interface ApplicantDao {
	void saveApplicant(Applicant applicant);
	void deleteApplicant(String id);
	void updateApplicant(String id);
	List findAllApplicants();
	Applicant findApplicantById(String id);
	List findApplicantByIsstock(String isstock);
}
