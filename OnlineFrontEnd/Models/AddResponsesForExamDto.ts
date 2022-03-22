import { ExamInformationDto } from "./ExamInformationDto";
import { ResponseInfoDto } from "./ResponseInfoDto";

export class AddResponsesForExamDto extends ExamInformationDto{

	 
    responseList : ResponseInfoDto[];
}