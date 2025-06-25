(... 생략 ...)
public class QuestionController {

    (... 생략 ...)

    @PostMapping("/create")
    public String questionCreate(@RequestParam(value="subject") String subject, 
                                 @RequestParam(value="content") String content){
        this.questionService.create(subject, content);
    return "redirect:/question/list";
}
}
