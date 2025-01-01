package controllers;

import exceptions.LoginDoesNotExistException;
import model.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.LoginService;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public ResponseEntity<Account> login(
            @RequestParam String name,
            @RequestParam String passkey
    ){
        return loginService.login(name,passkey);
    }
}
