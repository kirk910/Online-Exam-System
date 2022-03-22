package com.lti.appl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.appl.beans.Exam;

@Repository
public interface ExamDao {

	//ExamDetail Operations
		public Exam getOneExam(int ExamId);
		public List<Exam> getAllExams();
		public void addExam(Exam ref);
		public void removeExam(int ExamId);
		public Exam getOneExam(String examspecialization, String examlevel);
}
