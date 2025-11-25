(... 생략 ...)
import java.security.Principal;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;
(... 생략 ...)
public class QuestionController {

    private final QuestionService questionService;
    private final UserService userService;

    (... 생략 ...)

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, 
            BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
        return "redirect:/question/list";
    }
}
