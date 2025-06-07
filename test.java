


@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message="제목은 필수항목입니다.")
    @Size(max=200)
    private String subject;

    @NotEmpty(message="내용은 필수항목입니다.")
    private String content;
}








public class QuestionService {

    public void create(String subject, String content) {
      Question q = new Question();
      q.setSubject(subject);
      q.setContent(content);
      q.setCreateDate(LocalDateTime.now();
      this.questionRepository.sav(q);
    }
}






public class QuestionController {
    
	@GetMapping("/list")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "kw", defaultValue = "") String kw) {
		log.info("page:{}, kw:{}", page, kw);
		Page<Question> paging = this.questionService.getList(page, kw);
		model.addAttribute("paging", paging);
		model.addAttribute("kw", kw);
		return "question_list";
	}
    

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
	Question question = this.questionService.getQuestion(id);
	model.addAttribute("question", question);
	return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm, BindingResult bindingResult){
    if(bindingResult.hasErrors()){
        return "question_form";
    }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
    return "redirect://question/list";
      }
    
}







package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/sbb")
    @ResponseBody
    public String index() {
        return "안녕하세요 sbb에 오신 것을 환영합니다.";
    }
}








@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
	    return "hello World";
    }
}








