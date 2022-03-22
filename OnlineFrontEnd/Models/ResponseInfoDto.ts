import { ExamInformationDto } from "./ExamInformationDto";

export class ResponseInfoDto extends ExamInformationDto {
	 
	userId : number	;						
	questionId : number;
    response : string;
}