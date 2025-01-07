package controllers;

import org.springframework.web.bind.annotation.*;
import services.SignupService;

@CrossOrigin
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
