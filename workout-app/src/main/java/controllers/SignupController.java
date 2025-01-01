package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.SignupService;

@RestController
public class SignupController {
    private final SignupService signupService;

    public SignupController(SignupService signupService){
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public void signup(
            @RequestParam String name,
            @RequestParam String passkey
    ){
        signupService.signup(name,passkey);
    }
}
