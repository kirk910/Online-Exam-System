import { ExamInformationDto } from "./ExamInformationDto";

export class QuestionDetailsDto extends  ExamInformationDto {


        questionid : number;
        question : string;
        optionA : string;
        optionB : string;
        optionC : string;
        optionD : string;

}