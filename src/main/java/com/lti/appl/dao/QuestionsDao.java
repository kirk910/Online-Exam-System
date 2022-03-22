package com.lti.appl.dao;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.appl.beans.*;

@Component
@Repository
public interface QuestionsDao {
	

	
	  public List<Questions> getQuestions(int examId);//imp1
	  public Questions getOneQuestion(int qId);//imp2
	  public void addQuestion(Questions question);  //imp3
	  public void deleteQuestionByHql(int questionId); //imp4
	  public void deleteQuestion(int questionId);
	  public void updateQuestion(Questions question);//imp5
	  public void deleteQuestionsByExam(int examId);//imp6

}
