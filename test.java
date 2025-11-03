(... 생략 ...)
import java.security.Principal;
(... 생략 ...)
public class AnswerController {

    (... 생략 ...)

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, 
            @Valid AnswerForm answerForm, BindingResult bindingResult, Principal principal) {
        (... 생략 ...)
    }
}
