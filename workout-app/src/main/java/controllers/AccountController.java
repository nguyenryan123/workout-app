package controllers;

import model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.AccountRepository;
import services.LoginService;

@RestController
public class AccountController {
    private final AccountRepository accountRepository;
    private final LoginService loginService;

    @Autowired
    public AccountController(AccountRepository accountRepository, LoginService loginService){
        this.accountRepository = accountRepository;
        this.loginService = loginService;
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAccounts(){
        return accountRepository.findAll();
    }

    @PostMapping("/accounts")
    public void insertAccount(
            @RequestBody Account account
    ){
        accountRepository.insertAccount(account.getName(), account.getPasskey());
    }

    @GetMapping("/getAccount")
    public Account getAccount(
            @RequestParam String name,
            @RequestParam String passkey
    ){
        return accountRepository.findAccountByNameAndPasskey(name,passkey);
    }
}
