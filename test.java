(... 생략 ...)
public class QuestionService {

    (... 생략 ...)

    public void delete(Question question){
    this.questionRepository.delete(question);
}

}
