(... 생략 ...)

public class QuestionController {

    (... 생략 ...)

    @GetMapping("/create")
    public String questionCreate(){
    return "question_form";
}
