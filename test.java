(... 생략 ...)
public class QuestionController {

    (... 생략 ...)

    @GetMapping(value = "/question/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id){
	Question question = this.questionService.getQuestion(id);
	model.addAttribute("question", question);
	return "question_detail"
		}
}
