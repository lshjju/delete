(... 생략 ...)
public class QuestionController {

    (... 생략 ...)

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String questionDelete(
    Principal principal,
    @PathVariable("id") Integer id
    ) {
    Question question = this.questionService.getQuestion(id);
    if(!question.getAuthor().getUsename().equals(principal.getName())){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
    }
    this.questionService.delete(question);
    return "redirect:/";
        
    }
}
