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


@PostMapping("/create")
  public String questionCreate(@RequestParam(value="subject") String subject, @RequsetParam(value="content") String content){
    return "redirect://question/list";
  }
