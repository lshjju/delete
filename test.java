package com.mysite.sbb.question;

(... 생략 ...)
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
(... 생략 ...)
public class QuestionController {

    (... 생략 ...)

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page)) 
    {
       Page<Question> paging = this.questionService.getList(page);
        model.addAttribue("paging", paging);
    
        
        return "question_list";
    }

    (... 생략 ...)
}
