package controllers;

import model.Account;
import model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.AccountRepository;
import repositories.WorkoutRepository;
import services.LoginService;

import java.util.List;


//delete later
@CrossOrigin
@RestController
public class AccountController {
    private final AccountRepository accountRepository;
    private final WorkoutRepository workoutRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository,
                             WorkoutRepository workoutRepository){
        this.accountRepository = accountRepository;
        this.workoutRepository = workoutRepository;
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAccounts(){
        return accountRepository.findAll();
    }

    @GetMapping("/w")
    public Iterable<Workout> getWorkouts(){
        return workoutRepository.findAll();
    }

    @GetMapping("/workouts")
    public List<Workout> getWorkout(
            @RequestParam String userid
    ){
        Long user_id = Long.parseLong(userid);
        return workoutRepository.findByUserId(user_id);
    }

    @PostMapping("/workouts")
    public void addWorkout(
            @RequestParam String workoutName,
            @RequestParam String userId
    ){
        Long user_id = Long.parseLong(userId);
        workoutRepository.insertWorkout(workoutName,user_id);
    }
}
