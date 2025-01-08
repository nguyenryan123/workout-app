package model;

import org.springframework.data.annotation.Id;

public class Workout {
    @Id
    private long workoutId;

    private String workoutName;
    private long userId;

    public long getWorkoutId() {
        return workoutId;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public long getUserId() {
        return userId;
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
