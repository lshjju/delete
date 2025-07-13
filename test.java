(... 생략 ...)
public class QuestionController {

    (... 생략 ...)

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    (... 생략 ...)
}
