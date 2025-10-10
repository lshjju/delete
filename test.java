package com.mysite.sbb.user;

(... 생략 ...)
import org.springframework.dao.DataIntegrityViolationException;
(... 생략 ...)
public class UserController {

    (... 생략 ...)

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", 
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }


        try{
            userService.create(userCreateForm.getUsername(), 
                    userCreateForm.getEmail(), userCreateForm.getPassword1());

        }catch(DataIntegrityViolationException e){
            e.printStactTrace();
            bindingResult.reject("signupFailled", "이미 등록된 사용자입니다.");
            return "singup_form";
        }catch(Exception e){
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }
        return "redirect:/";
    }
}
