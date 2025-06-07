package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller - 
// public - 
// @GetMapping - 
// @ResponseBody - 
// public - 겟매핑 유알엘과 메서드네임은 달라도 됨
// return - 리턴 값 뷰에 출력
@Controller
public class HelloController {
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello Spring Boot Board";
	}
}
