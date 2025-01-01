package controllers;

import model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import repositories.AccountRepository;

@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAccounts(){
        return accountRepository.findAll();
    }
}
