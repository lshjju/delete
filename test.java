(... 생략 ...)
import org.springframework.web.bind.annotation.PathVariable;
(... 생략 ...)
public class QuestionController {

    (... 생략 ...)

    @GetMapping(value = "/question/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
    
        return "question_detail";
    }
}
