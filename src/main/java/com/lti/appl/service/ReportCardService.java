package com.lti.appl.service;

import java.util.Set;

import com.lti.appl.dao.*;


public interface ReportCardService {
	
	public Set<ReportCardDto> getReportCardService(int userId);
	public Set<UserInfoDto> searchStudentService(SearchStudentDto ssDto);
	public String generateReportCard(int examid, int userid);


}
