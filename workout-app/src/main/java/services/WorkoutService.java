package services;

import model.Workout;
import model.WorkoutDetails;
import model.WorkoutSet;
import org.springframework.stereotype.Service;
import repositories.WorkoutRepository;
import repositories.WorkoutSetRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;
    private final WorkoutSetRepository workoutSetRepository;

    public WorkoutService(WorkoutRepository workoutRepository, WorkoutSetRepository workoutSetRepository){
        this.workoutRepository = workoutRepository;
        this.workoutSetRepository = workoutSetRepository;
    }

    public void addWorkout(String workoutName, Long userId){
        workoutRepository.insertWorkout(workoutName, userId);
    }

    public List<Workout> getAllWorkoutsFromUserId(Long userId){
        return workoutRepository.findByUserId(userId);
    }

    public void addSet(BigDecimal weight, int reps, Long workoutId, String workoutDate){
        LocalDate workout_date = LocalDate.parse(workoutDate);
        workoutSetRepository.addSetToWorkout(weight, reps, workoutId, workout_date);
    }

    public List<WorkoutSet> getAllSetsFromWorkout(Long workoutId){
        return workoutSetRepository.findSetsFromWorkout(workoutId);
    }

    public WorkoutDetails getWorkoutDetailsFromWorkoutId(Long workoutId, LocalDate date){
        WorkoutDetails workoutDetails = new WorkoutDetails();
        Workout workout = workoutRepository.findByWorkoutId(workoutId);
        workoutDetails.setWorkout_id(workoutId);
        workoutDetails.setWorkout_name(workout.getWorkoutName());
        List<WorkoutSet> sets = workoutSetRepository.findSetsFromWorkoutWithDate(workoutId, date);
        workoutDetails.setSets(sets);
        return workoutDetails;
    }
}
