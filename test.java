(... 생략 ...)
import com.mysite.sbb.answer.AnswerForm;
(... 생략 ...)
public class QuestionController {

    (... 생략 ...)

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        (... 생략 ...)
    }

    (... 생략 ...)
}
