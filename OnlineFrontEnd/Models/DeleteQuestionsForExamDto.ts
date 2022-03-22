import { DeleteQuestionDto } from "./DeleteQuestionDto";
import { ExamInformationDto } from "./ExamInformationDto";

export class DeleteQuestionsForExamDto extends ExamInformationDto {
	 
    questionsList:DeleteQuestionDto[];
    
}