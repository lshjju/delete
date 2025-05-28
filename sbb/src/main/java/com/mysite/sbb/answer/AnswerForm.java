package com.mysite.sbb.answer;

import jakarta.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// public - QuestionForm과 동일 - 앤서니까 제목은 필요없음 - 엔티티 생성
// @NotEmpty - 
// private - 
public class AnswerForm {
	@NotEmpty(message = "내용은 필수항목입니다.")
	private String content;
}
