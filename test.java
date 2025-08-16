(... 생략 ...)
import java.util.Optional;
import com.mysite.sbb.DataNotFoundException;
(... 생략 ...)
public class QuestionService {

    (... 생략 ...)

    public Question getQuestion(Integer id) {
        Optional<Question> quetion = this.questionRepository.findById(id);
    if(question.isPresent()){
    return question.get();
    }else{
        throw new DataNotFoundException("question not found");
    }
    
        
        
    }
}
