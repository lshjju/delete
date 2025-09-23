(... 생략 ...)
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Sort;
(... 생략 ...)
public class QuestionService {

   (... 생략 ...)

    public Page<Question> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"))
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }

    (... 생략 ...)
}
