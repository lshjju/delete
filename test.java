(... 생략 ...)
public class AnswerController {

    (... 생략 ...)

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String answerModify(@Valid AnswerForm answerForm, BindingResult bindingResult, @PathVariable("id") Integer id, Principal principal) {
    if(bindingResult.hasErrors()){
        return "answer_form";
    }
    Answer answer = this.answerService.getAnswer(id);
    if(!answer.getAnswer().getUsername().equals(principal.getName())){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
    }
    this.answerService.modify(answer, answerForm.getContent());
    return String.format("redirect:/question/detail/%s", answer.getQuestion().getId());
        
        
    }
}
