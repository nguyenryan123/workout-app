package controllers;

import model.Account;
import model.Workout;
import model.WorkoutSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.AccountRepository;
import repositories.WorkoutRepository;
import repositories.WorkoutSetRepository;
import services.LoginService;
import services.WorkoutService;

import java.math.BigDecimal;
import java.util.List;


//delete later
@CrossOrigin
@RestController
public class AccountController {
    private final AccountRepository accountRepository;
    private final WorkoutService workoutService;

    @Autowired
    public AccountController(AccountRepository accountRepository,
                             WorkoutService workoutService){
        this.accountRepository = accountRepository;
        this.workoutService = workoutService;
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAccounts(){
        return accountRepository.findAll();
    }
}
