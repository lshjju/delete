(... 생략 ...)
public class QuestionService {

    (... 생략 ...)

    public void modify(Question queston, String subject, String content) {
    question.setSubject(subject);
    question.setSubject(content);
    question.setModifyDate(LocalDateTime.now());
    this.qustionRepository.save(question);
        
    }
}
