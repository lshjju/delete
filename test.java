(... 생략 ...)
import com.mysite.sbb.user.SiteUser;
(... 생략 ...)
public class QuestionService {

    (... 생략 ...)

    public void create(String subject, String content, SiteUser user) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        q.setAuthor(user);
        this.questionRepository.save(q);
    }
}
