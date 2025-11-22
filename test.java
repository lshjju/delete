(... 생략 ...)
import com.mysite.sbb.user.SiteUser;
(... 생략 ...)
public class AnswerService {

    (... 생략 ...)

    public Answer create(Question question, String content, SiteUser author) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAUthor(author);
        this.answerRepository.save(answer);
        return answer;
    }
}
