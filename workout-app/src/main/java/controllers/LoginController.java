package controllers;

import exceptions.LoginDoesNotExistException;
import model.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.LoginService;

@CrossOrigin
@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<Account> login(
            @RequestParam String name,
            @RequestParam String passkey
    ){
        return loginService.login(name,passkey);
    }
}
