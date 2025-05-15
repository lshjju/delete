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
