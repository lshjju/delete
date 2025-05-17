package com.mysite.sbb.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


// @Getter - 
// @Setter - 
// public - 콘트롤러 콜 받음 - 검증 담당 폼을 처리할 클래스를 따로 빌딩 - 폼클래스는 검증과 함께 매핑되는 바인딩도 같이 함 -여기서는 question_form subject content 와 매핑
// @NotEmpty - 이상한 놈 멀쩡하게 만들기 클래스 - 필수입력 같은거 안 넣거나 룰 안지키면 경고 때려줌
// @Size - 위와 같음	
// private - 퀘스천폼 - <input name="subject"> 와 자동으로 폼 바인딩 - 에러 여부를 담아서 콘트롤러로 보냄
// @NotEmpty - 이상한 놈 멀쩡하게 만들기 클래스 - 필수입력 같은거 안 넣거나 룰 안지키면 경고 때려줌
// private - 퀘스천폼 - <textarea name="content"> 와 자동으로 폼 바인딩 - 에러 여부를 담아서 콘트롤러로 보냄
@Getter
@Setter
public class QuestionForm {
	@NotEmpty(message = "제목은 필수항목입니다.")
	@Size(max = 200)
	private String subject;

	@NotEmpty(message = "내용은 필수항목입니다.")
	private String content;
}
