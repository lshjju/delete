(... 생략 ...)
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
(... 생략 ...)
public class QuestionService {

    (... 생략 ...)

    public Page<Question> getList(int page){
    Pageable pageable = PageRequest.of(page, 10);
    retun this.questionRepository.findAll(pabeble);
    }

    (... 생략 ...)
}
