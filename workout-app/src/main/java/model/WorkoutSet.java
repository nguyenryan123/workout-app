package model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

public class WorkoutSet {
    @Id
    private long setId;

    private BigDecimal weight;
    private int reps;

    private long workoutId;

    private LocalDate workoutDate;

    public long getWorkoutId() {
        return workoutId;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public long getSetId() {
        return setId;
    }

    public int getReps() {
        return reps;
    }

    public LocalDate getWorkoutDate() {
        return workoutDate;
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public void setSetId(long setId) {
        this.setId = setId;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setWorkoutDate(LocalDate workoutDate) {
        this.workoutDate = workoutDate;
    }
}
