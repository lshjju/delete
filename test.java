(... 생략 ...)
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
(... 생략 ...)
public class AnswerController {

    (... 생략 ...)

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, 
            @Valid AnswerForm answerForm, BindingResult bindingResult) {
        Question question = this.questionService.getQuestion(id);
        if(bindingResult.hasErrors()){
        model.addAttribute("question", question);
            return "question_detail";
        }
        this.answerService.create(question, answerForm.getContent());
        return String.format("redirect:/question/detail/%s", id);
    }
}
