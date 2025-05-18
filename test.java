@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message="제목은 필수항목입니다.")
    @Size(max=200)
    private String subject;

    @NotEmpty(message="내용은 필수항목입니다.")
    private String content;
}


public class QuestionService {

    public void create(String subject, String content) {
      Question q = new Question();
      q.setSubject(subject);
      q.setContent(content);
      q.setCreateDate(LocalDateTime.now();
      this.questionRepository.sav(q);
    }
}

public class QuestionController {

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm, BindingResult bindingResult){
    if(bindingResult.hasErrors()){
        return "question_form";
    }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
    return "redirect://question/list";
      }
    
}



