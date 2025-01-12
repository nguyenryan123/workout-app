package services;

import model.Workout;
import model.WorkoutDetails;
import model.WorkoutSet;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import repositories.WorkoutRepository;
import repositories.WorkoutSetRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
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
        List<Workout> workoutList = workoutRepository.findByUserId(userId);
        workoutList.sort(Comparator.comparingLong(Workout::getWorkoutId));
        return workoutList;
    }

    public void addSet(BigDecimal weight, int reps, Long workoutId, LocalDate workoutDate){
        workoutSetRepository.addSetToWorkout(weight, reps, workoutId, workoutDate);
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

        if(sets.isEmpty()){
            throw new IndexOutOfBoundsException();
        }

        sets.sort(Comparator.comparingLong(WorkoutSet::getSetId));
        workoutDetails.setSets(sets);
        workoutDetails.setEarliestSet(sets.get(0).getSetId());
        return workoutDetails;
    }

    public List<WorkoutDetails> allWorkoutDetailsFromUserId(Long userId, LocalDate date){
        List<Workout> workoutList = getAllWorkoutsFromUserId(userId);
        ArrayList<WorkoutDetails> workoutDetailsList = new ArrayList<>();
        for(Workout workout : workoutList){
            long workoutId = workout.getWorkoutId();
            WorkoutDetails workoutDetails = new WorkoutDetails();

            try{
                workoutDetails = getWorkoutDetailsFromWorkoutId(workoutId, date);
                workoutDetailsList.add(workoutDetails);
            }
            catch(IndexOutOfBoundsException e){}
        }

        workoutDetailsList.sort(Comparator.comparing(WorkoutDetails::getEarliestSet));
        return workoutDetailsList;
    }

    public void deleteWorkoutFromWorkoutId(Long workoutId){
        workoutRepository.deleteWorkout(workoutId);
    }

    public void deleteSetFromSetId(Long setId){
        workoutSetRepository.deleteSetWithSetId(setId);
    }

    public void editWorkoutName(String workoutName, Long workoutId){
        workoutRepository.editWorkoutName(workoutName, workoutId);
    }

    public void editWorkoutSetWeight(BigDecimal weight, Long setId){
        BigDecimal num = new BigDecimal(-1);
        if(weight.equals(num)) return;

        //if -1 is passed through update is cancelled
        workoutSetRepository.editSetWeight(weight, setId);
    }

    public void editWorkoutSetReps(int reps, Long setId){
        if(reps == -1) return;

        //if -1 is passed through update is cancelled
        workoutSetRepository.editSetReps(reps, setId);
    }

//    public List<Integer> daysWithWorkoutInMonth(Long userId, LocalDate start, LocalDate end){
//        List<Long> workoutIdList = workoutRepository.getAllWorkoutIds(userId);
//        List<Integer> daysWithWorkout = new ArrayList<>();
//
//        for(int i = 1; i < end.getDayOfMonth() + 1; i++){
//            LocalDate date = LocalDate.of(start.getYear(), start.getMonth(), i);
//            List<WorkoutSet> workoutSetList = workoutSetRepository.
//        }
//
//    }

    public List<Integer> daysWithWorkout(Long userId, LocalDate start, LocalDate end){
        ArrayList<Integer> dayList = new ArrayList<>();

        for(int i = 1; i < end.getDayOfMonth() + 1; i++){
            LocalDate date = LocalDate.of(start.getYear(), start.getMonth(), i);
            List<WorkoutDetails> workoutDetailsList = allWorkoutDetailsFromUserId(userId, date);
            if(!workoutDetailsList.isEmpty()){
                dayList.add(i);
            }

        }

        return dayList;


    }
}
