(... 생략 ...)
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
(... 생략 ...)
public class QuestionController {

    (... 생략 ...)

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if(binddingResult.hasErrors()){
            return "question_form";
}
        this.questionService.create(questionForm.getSubject(), questioForm.getContent());
        return "redirect:/question/list";
    }
}
