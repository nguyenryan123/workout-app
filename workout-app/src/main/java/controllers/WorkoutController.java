package controllers;

import model.Workout;
import model.WorkoutDetails;
import model.WorkoutSet;
import org.springframework.web.bind.annotation.*;
import services.WorkoutService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class WorkoutController {
    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @GetMapping("/workouts")
    public List<Workout> getWorkouts(
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate date = LocalDate.parse(workoutDate, formatter);
        workoutService.addSet(weight, reps, workoutId, date);
    }

    @GetMapping("/workoutDetails")
    public WorkoutDetails getWorkoutDetails(
            @RequestParam Long workoutId,
            @RequestParam String date
    ){
        LocalDate workoutDate = LocalDate.parse(date);
        return workoutService.getWorkoutDetailsFromWorkoutId(workoutId, workoutDate);
    }

    @GetMapping("/allWorkoutDetails")
    public List<WorkoutDetails> allWorkoutDetails(
            @RequestParam long userId,
            @RequestParam String date
    ){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate workoutDate = LocalDate.parse(date, formatter);
        return workoutService.allWorkoutDetailsFromUserId(userId, workoutDate);
    }

    @PostMapping("/deleteWorkout")
    public void deleteWorkout(
            @RequestParam long workoutId
    ){
        workoutService.deleteWorkoutFromWorkoutId(workoutId);
    }

    @PostMapping("/deleteSet")
    public void deleteSet(
            @RequestParam long setId
    ){
        workoutService.deleteSetFromSetId(setId);
    }

    @PostMapping("/editWorkout")
    public void editWorkout(
            @RequestParam String workoutName,
            @RequestParam Long workoutId
    ){
        workoutService.editWorkoutName(workoutName, workoutId);
    }

    @PostMapping("/editSet")
    public void editSet(
            @RequestParam BigDecimal weight,
            @RequestParam int reps,
            @RequestParam Long setId
    ){
        workoutService.editWorkoutSetWeight(weight,setId);
        workoutService.editWorkoutSetReps(reps,setId);
    }
}
