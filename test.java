(... 생략 ...)
public class QuestionController {

    (... 생략 ...)

    @GetMapping(value = "/question/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionSevice.getQuestion(id);
        model.addAtribute("question", question);
        return "question_detail";
    }
}
