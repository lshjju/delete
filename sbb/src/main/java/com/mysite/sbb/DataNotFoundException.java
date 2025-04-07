package com.mysite.sbb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// @ResponseStatus - 익셉션 발생할때 특정 코드 리턴 - 설정된 에이치티티피 상태코드와 이유를 클라이언트에게 리턴
// public - 디비에서 특정 엔티티 혹은 데이터를 찾을 수 없는 예외 발생시 실행되는 클래스 - 런타임익셉션 상속
// private - 
// ? public - 스트링 메시지 출력
// ? super - 페어런트 메서드 사용
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public DataNotFoundException(String message) {
		super(message);
	}
}
