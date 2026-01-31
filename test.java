(... 생략 ...)
public class QuestionService {

    (... 생략 ...)

    public void modify(Question question, String subject, String content) {

    question.setSubject(subject);
    question.setContent(content);
    question.setModifyDate(LocalDateTime.now());
    this.questionRepository.save(question);
    
        
    }
}
