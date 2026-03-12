(... 생략 ...)
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;
(... 생략 ...)
public class AnswerController {

    (... 생략 ...)

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String answerModify(AnswerForm answerForm, @PathVariable("id") Inger id, Principal principal) {
    Answer answer = this.answerService.getAnswer(id);
    if(bindingResult.hasErrors()){
        return "answer_form"
    }
            Answer answer = this.answerService.getAnswer(id);

    if(!answer.getAuthor().getUsername().equals(principal.getName())){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        
    }
    this.answerService.modify(answer, answerForm.getConent());
    return String.format("redirect:/question/detail/%s", answer.getQuestion().getId());
        
    }
}
