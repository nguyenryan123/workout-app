package repositories;

import model.WorkoutSet;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkoutSetRepository extends CrudRepository<WorkoutSet,Long> {

    @Modifying
    @Query("INSERT INTO workout_set (weight, reps, workout_id, workout_date) VALUES (:weight, :reps, :workout_id, :workout_date)")
    void addSetToWorkout(BigDecimal weight, int reps, Long workout_id, LocalDate workout_date);

    @Query("SELECT * FROM workout_set WHERE workout_id = :workout_id")
    List<WorkoutSet> findSetsFromWorkout(Long workout_id);

    @Query("SELECT * FROM workout_set WHERE workout_id = :workout_id AND workout_date = :workout_date")
    List<WorkoutSet> findSetsFromWorkoutWithDate(Long workout_id, LocalDate workout_date);

    @Modifying
    @Query("DELETE FROM workout_set WHERE set_id = :set_id")
    void deleteSetWithSetId(Long set_id);

    @Modifying
    @Query("UPDATE workout_set SET weight = :weight WHERE set_id = :set_id")
    void editSetWeight(BigDecimal weight, Long set_id);

    @Modifying
    @Query("UPDATE workout_set SET reps = :reps WHERE set_id = :set_id")
    void editSetReps(int reps, Long set_id);
}
