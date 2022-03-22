package com.lti.appl.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.beans.Questions;
import com.lti.appl.dao.AddQuestionsForExamDto;
import com.lti.appl.dao.AddResponsesForExamDto;
import com.lti.appl.dao.AdminLoginDto;
import com.lti.appl.dao.DeleteQuestionsForExamDto;
import com.lti.appl.dao.ExamInformationDto;
import com.lti.appl.dao.Message;
import com.lti.appl.dao.QuestionDetailsDto;
import com.lti.appl.dao.QuestionsDao;
import com.lti.appl.dao.ReportCardDto;
import com.lti.appl.dao.ResetPasswordDto;
import com.lti.appl.dao.SearchStudentDto;
import com.lti.appl.dao.UserDao;
import com.lti.appl.dao.UserInfoDto;
import com.lti.appl.dao.UserLoginDto;
import com.lti.appl.dao.UserRegisterDto;
import com.lti.appl.exception.OnlineExamException;
import com.lti.appl.service.ExamService;
import com.lti.appl.service.LoginService;
import com.lti.appl.service.ReportCardService;

@RestController
@CrossOrigin("*")
public class OnlineExamSystemController {
	
	@Autowired
	LoginService lSer;
	
	@Autowired
	ExamService eSer;
	
	@Autowired
	ReportCardService rcSer;
	
	@Autowired
	UserDao udRepo;
	
	@Autowired
	QuestionsDao qdRepo;
	
	
//	@RequestMapping("/")
//	@ResponseBody
//	public String home() {
//		return "<h1>Welcom to Online Exam System </h1>";
//		
//	}
	
	@RequestMapping("/home")
	@ResponseBody
	public String home2() {
		return "<h2>Welcome to Online Exam System homepage </h2>";
		
	}
	
	@PostMapping(path="/userlogin")//to login
	public UserInfoDto userLoginService(@RequestBody UserLoginDto ulDto) {
		//Status status = new Status();
		
			
			UserInfoDto userInfoDto = new UserInfoDto();
			try {
				userInfoDto = lSer.userLoginService(ulDto);
				
			} catch (OnlineExamException e) {
				System.out.println("Error : "+e.getMessage());
			}
			return userInfoDto;
			
	}	
	
//	@GetMapping(path="/GetUsersByEmail/{email}")
//	
//	public User getuserbyemail(@PathVariable(value = "email") String email) {
//		User ud=udRepo.getOneUser(email);
//		
//		return ud;
//	}
	
	@PostMapping(path="/adminlogin")//to login
	public AdminLoginDto adminLoginService(@RequestBody AdminLoginDto alDto) {
			
		AdminLoginDto adminLoginDto = new AdminLoginDto();
			try {
				adminLoginDto = lSer.adminLoginService(alDto);
				
			} catch (OnlineExamException e) {
				System.out.println("Error : "+e.getMessage());
			}
			return adminLoginDto;
			
	}	
	
	
	
	@PostMapping(path="/addquestionsforexam")//to add questions for a particular exam
	public String addQuestionsForExamService(@RequestBody AddQuestionsForExamDto aqeDto) {
		
		try {
			eSer.addQuestionsForExamService(aqeDto);
			System.out.println("Added successfully");
			return "Y";
			
		}catch (OnlineExamException e) {
			
			return e.getMessage();		
		}
		
	}
	
	@PostMapping(path="/getquestionsforexam")//to display all questions of a selected exam
	public Set<QuestionDetailsDto> getAllquestionsForExamService(@RequestBody ExamInformationDto examInfoDto){
		Set<QuestionDetailsDto> qList = eSer.getAllquestionsForExamService(examInfoDto);
		return qList;
		
	}
	
	@PutMapping(path="/resetpassword")//to reset password
	public Message resetPasswordService(@RequestBody ResetPasswordDto rpDto) {
		
		Message message = new Message();
		try {
			String msg = lSer.resetPasswordService(rpDto);
			message.setStatus("Y");
			message.setMsg(msg);
			return message;
		} catch (OnlineExamException e) {
			message.setStatus("N");
			message.setMsg(e.getMessage());
			return message;
		}
		
		
	}
	
	@GetMapping(path="/getallexams")//to display the information of all exams
	public Set<ExamInformationDto> selectExamsService(){
		
		Set<ExamInformationDto> allExams = eSer.selectExamsService();
		return allExams;
		
	}
	
//	@GetMapping(path="/getallquestions/{eid}")
//	public List<Questions> getquestionsbyexam(@PathVariable(value = "eid") int examId){
//		
//		List<Questions> questions = qdRepo.getQuestions(examId);
//		return questions;
//	}
	

	
	@PostMapping(path="/deletequestionsforexam")//to delete questions of a particualr exam
	public String deleteQuestionsForExamService(@RequestBody DeleteQuestionsForExamDto dqeDto) {
		
		String status;
		try {
			status = eSer.deleteQuestionsForExamService(dqeDto);
			return status;
		} catch (OnlineExamException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		
		
	}
	
	
	@GetMapping(path="/getreportcard/{userid}")//to get list of reportcards for a user.
	public  Set<ReportCardDto> getReportCardService(@PathVariable(value = "userid") int userId){
		
		Set<ReportCardDto> reportCardsDtoSet = rcSer.getReportCardService(userId);
		
		return reportCardsDtoSet;
	}
		
		
	@PostMapping(path="/searchstudentsinfo")	//gives the info of students, where there some searching criteria like(city,state,exam,marks)
	public Set<UserInfoDto> searchStudentService(@RequestBody SearchStudentDto ssDto){
		
		Set<UserInfoDto> userInfoDtoList = rcSer.searchStudentService(ssDto);
		return userInfoDtoList;
	}
	
	@PostMapping(path="/addresponses")//to add responses after completing the exam. It will also generate the reportcard for that particular exam
	public ReportCardDto addResponsesService(@RequestBody AddResponsesForExamDto areDto) {
		
		
		System.out.println("\n in controller....................");
		System.out.println(areDto.getExamLevel());
		System.out.println(areDto.getResponseList());
		ReportCardDto reportCard = eSer.addResponsesService(areDto);
		return reportCard;
			
	}
	
	@PostMapping(path="/registeruser")//to register a new user
	public Message userRegisterService(@RequestBody UserRegisterDto rgDto) {
		Message message = new Message();
		try {
			String status = lSer.userRegisterService(rgDto);
			message.setStatus("Y");
			message.setMsg(status);
		} catch (OnlineExamException e) {
			message.setStatus("N");
			message.setMsg("Unable to register" + e.getMessage());
		} 
		
		return message;
	}
	
	/*
	 * @GetMapping(path="/date") public Date getDate(){ return
	 * udRepo.getOneUser(1).getDateOfBirth(); }
	 */
	

}
