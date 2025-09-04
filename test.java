package com.mysite.sbb.question;

(... 생략 ...)
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
(... 생략 ...)
public class QuestionController {

    (... 생략 ...)

    @GetMapping("/create")
    public String questionCreate() {
        return "question_form";
    }

    @PostMapping("/create")
        public String questionCreate(@RequestParam(value="subject") String subject, 
                                     @RequestParam(value="content") String content){
        return "redirect:/question/list";

    }
}
