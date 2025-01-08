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

    @GetMapping("/workouts")
    public Iterable<Workout> getWorkouts(
            @RequestParam Long userId
    ){
        return workoutService.getAllWorkoutsFromUserId(userId);
    }

    @PostMapping("/workouts")
    public void addWorkout(
            @RequestParam String workoutName,
            @RequestParam Long userId
    ){
        workoutService.addWorkout(workoutName, userId);
    }

    @GetMapping("/sets")
    public List<WorkoutSet> getSets(
            @RequestParam Long workoutId
    ){
        return workoutService.getAllSetsFromWorkout(workoutId);
    }

    @PostMapping("/sets")
    public void addSetToWorkout(
            @RequestParam BigDecimal weight,
            @RequestParam int reps,
            @RequestParam Long workoutId,
            @RequestParam String workoutDate
            ){
        workoutService.addSet(weight, reps, workoutId, workoutDate);
    }
}
