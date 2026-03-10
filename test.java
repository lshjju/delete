(... 생략 ...)
import java.util.Optional;
import com.mysite.sbb.DataNotFoundException;
(... 생략 ...)
public class AnswerService {

    (... 생략 ...)

public Answer getAnswer(Integer id){
    Optional<Answer> answer = this.answerRepository.findById(id);
    if(answer.isPresent()){
        return answer.get();
        
    }
    else{
        throw new DataNotFoundException("answer not found");
    }
}

public void midify(Answer answer, String content){
    answer.setContent(content);
    answer.setModifyDate(LocalDateTime.now());
    this.answerRepository.save(answer);
}



    
}
