(... 생략 ...)
import org.springframework.web.bind.annotation.RequestMapping;
(... 생략 ...)

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        (... 생략 ...)
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        (... 생략 ...)
    }
}
