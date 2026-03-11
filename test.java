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
    if(){
        
    }
        
    }
}
