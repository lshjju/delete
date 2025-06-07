package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

// @GetMapping - 
// @ResponseBody - 
// public - 겟매핑 유알엘과 메서드네임은 달라도 됨
// return - 리턴 값 뷰에 출력	
	@GetMapping("/sbb")
	@ResponseBody
	public String index() {
		return "안녕하세요 sbb에 오신것을 환영합니다.";
	}

// @GetMapping - http://localhost:8080/ 콜
// public - 
// return - question/list 뷰 리다이렉트 - 이 유알엘을 메인페이지로 세팅
	@GetMapping("/")
	public String root() {
		return "redirect:/question/list";
	}
}
