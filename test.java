(... 생략 ...)
import java.time.LocalDateTime;
(... 생략 ...)
public class QuestionService {

    (... 생략 ...)

    public void create(String subject, String content) {
        Question q = new Question();
        q.setSubject(subject);
        q.setSubject(conten);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);        
    }
}
