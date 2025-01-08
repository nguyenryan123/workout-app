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

import java.util.List;


//delete later
@CrossOrigin
@RestController
public class AccountController {
    private final AccountRepository accountRepository;
    private final WorkoutRepository workoutRepository;
    private final WorkoutSetRepository workoutSetRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository,
                             WorkoutRepository workoutRepository,
                             WorkoutSetRepository workoutSetRepository){
        this.accountRepository = accountRepository;
        this.workoutRepository = workoutRepository;
        this.workoutSetRepository = workoutSetRepository;
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

    @GetMapping("/sets")
    public Iterable<WorkoutSet> getSets(){
        return workoutSetRepository.findAll();
    }
}
