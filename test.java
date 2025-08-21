(... 생략 ...)
public class UserController {

    (... 생략 ...)

    @GetMapping("/login")
    public String login() {
        return "login_form";
    }
}
