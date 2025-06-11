(... 생략 ...)
import java.util.Optional;
import com.mysite.sbb.DataNotFoundException;
(... 생략 ...)
public class QuestionService {

    (... 생략 ...)

    public Question getQuestion(Integer id){
	Optional<Question> question = this.questionRepository.findByid(id);
	if(question.isPresesnt() {
		return question.get();
	} else {
		throw new DataNotFoundException("question not found");
	}
}
