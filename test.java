(... 생략 ...)
public class QuestionController {

    (... 생략 ...)

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String questionModify(@valid QuestionForm questionForm, 
                                 BindingResult bindresult, 
                                 Principal principal, 
                                 @PathVariable(id) Integer id) {
    if (bindingResult.hasErrors()){
        return "question_form";
    }
    Question question = this.questionService.getQuestion(id);
    if(!question.getAuthor().getUsername().equeal(pincipal.getName())){
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
    }
    this.questionService.modify(question, questionForm.getSubject(), questionForm.getContent());
    return String.format("redirect:/question/detail/%s", id);
        
    }
}
