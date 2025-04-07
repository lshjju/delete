package com.mysite.sbb.question;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.mysite.sbb.answer.AnswerForm;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


// 유알엘을 매핑하기 위한 콘트롤러
// 질문 목록이 담긴 데이터를 조회하여 이를 템플릿을 통해 화면에 전달
// 질문 목록 관련 데이터를 조회하려면 퀘스천리포지토리 사용
// 퀘스천리포지토리로 조회한 질문 목록 데이터는 모델 클래스를 사용하여 템플릿에 전달


// @Slf4j - 
// @RequestMapping - 유알엘 접두사 또는 시작 부분으로 유알엘이 프리픽스로 알아서 딱딱 붙음 - /list = /question/list
// @RequiredArgsConstructor - 디아이 롤 - 롬복 제공 - 파이널이 붙은 속석을 포함하는 콘스트럭터 자동 생성 역할
// @Controller - 	
@Slf4j
@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

// 디아이 
	private final QuestionService questionService;
	private final UserService userService;

// @GetMapping - /question/list?page=0
// public - 모델오브젝/페이지값,파라미터없으면디폴트는0/검색어
// log - 
// Page - 서비스 콜해서 페이지 타입으로 세입
// model - 데이터 뷰로 전달
// model - 데이터 뷰로 전달
// return - 퀘스천리스트 뷰 리턴
	@GetMapping("/list")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "kw", defaultValue = "") String kw) {
		log.info("page:{}, kw:{}", page, kw);
		Page<Question> paging = this.questionService.getList(page, kw);
		model.addAttribute("paging", paging);
		model.addAttribute("kw", kw);
		return "question_list";
	}
	
// ? @GetMapping - 퀘스천리스트아이디뷰 콜 받음 - 배리어블네임은 아래 파라미터 배리어블네임과 같아야 함 - value 붙고 안붙고 차이?
// public - 모델/퀘스천아이디,변하는 아이디값은 패스배리어블 필요/앤서폼,question_detail이 거시기와 연결되었으므로 추가
// Question - 서비스 메서드 콜해서 배리어블에 해당 데이터 세입
// model - 배리어블에 네임 부여해서 뷰에서 출력 가능하게 함
// return - 퀘스천디테일뷰 리턴	
	@GetMapping(value = "/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {	
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/create")
	// question_form 에 th:object가 추가 되서 QuestionForm 필요
	public String questionCreate(QuestionForm questionForm) {
		return "question_form";
	}

	@PreAuthorize("isAuthenticated()")
// question_form에서 subject와 content를 포스트매핑으로 받음
	@PostMapping("/create")
// 이걸 파라미터로 넘겨줌
// 이렇게 일단 정보를 받아 둠
// 오버로딩
// @Valid - subject content를 알아서 바인딩해서 QuestionForm으로 가져감
// QuestionForm에서 검증하고 이리로 다시 넘어옴
// BindingResult - 검증 결과 - 위치는 항상 @Valid 뒤
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal) {
// 에러 있으면 아래 코드 리턴
		if (bindingResult.hasErrors()) {
			return "question_form";
		}
		SiteUser siteUser = this.userService.getUser(principal.getName());
// questionService create 메서드 콜해서 검증된 파라미터 넘김
		this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
// QuestionService가 저장하면 이리로 다시 넘어 와서 아래 코드 실행
		return "redirect:/question/list";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/modify/{id}")
	public String questionModify(QuestionForm questionForm, @PathVariable("id") Integer id, Principal principal) {
		Question question = this.questionService.getQuestion(id);
		if (!question.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
		}
		questionForm.setSubject(question.getSubject());
		questionForm.setContent(question.getContent());
		return "question_form";
	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/modify/{id}")
	public String questionModify(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal,
			@PathVariable("id") Integer id) {
		if (bindingResult.hasErrors()) {
			return "question_form";
		}
		Question question = this.questionService.getQuestion(id);
		if (!question.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
		}
		this.questionService.modify(question, questionForm.getSubject(), questionForm.getContent());
		return String.format("redirect:/question/detail/%s", id);
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/delete/{id}")
	public String questionDelete(Principal principal, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		if (!question.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
		}
		this.questionService.delete(question);
		return "redirect:/";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/vote/{id}")
	public String questionVote(Principal principal, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		SiteUser siteUser = this.userService.getUser(principal.getName());
		this.questionService.vote(question, siteUser);
		return String.format("redirect:/question/detail/%s", id);
	}
}
