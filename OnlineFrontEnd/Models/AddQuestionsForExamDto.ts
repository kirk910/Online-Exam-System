import { AddQuestionDto } from "./AddQuestionDto";
import { ExamInformationDto } from "./ExamInformationDto";


export class AddquestionsForExamDto extends ExamInformationDto {

    questionsList : AddQuestionDto[];

}