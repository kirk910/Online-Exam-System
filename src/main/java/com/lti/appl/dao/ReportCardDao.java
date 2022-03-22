package com.lti.appl.dao;

import java.util.List;

import com.lti.appl.beans.*;

public interface ReportCardDao {

	
	
    public void addReportCard(ReportCard ref);
    public void removeReportCard(int reportId);
    public List<ReportCard> getAllReportCards();
    public List<ReportCard> getReportCards(int userid);
	
}
