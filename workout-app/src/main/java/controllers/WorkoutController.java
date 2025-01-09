package controllers;

import model.Workout;
import model.WorkoutSet;
import org.springframework.web.bind.annotation.*;
import services.WorkoutService;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@RestController
public class WorkoutController {
    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @GetMapping("/workouts")
    public Iterable<Workout> getWorkouts(
            @RequestParam Long userId
    ){
//        Long user_id = Long.parseLong(userId);
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
