package model;

import java.time.LocalDate;
import java.util.List;

public class WorkoutDetails {
    private long workout_id;
    private String workout_name;
    private List<WorkoutSet> sets;
    private long earliestSet;

    public WorkoutDetails(){}

    public String getWorkout_name() {
        return workout_name;
    }

    public Long getWorkout_id() {
        return workout_id;
    }

    public List<WorkoutSet> getSets() {
        return sets;
    }

    public void setWorkout_name(String workout_name) {
        this.workout_name = workout_name;
    }

    public void setWorkout_id(Long workout_id) {
        this.workout_id = workout_id;
    }

    public void setSets(List<WorkoutSet> sets) {
        this.sets = sets;
    }

    public void setEarliestSet(long earliestSet) {
        this.earliestSet = earliestSet;
    }

    public long getEarliestSet() {
        return earliestSet;
    }
}
