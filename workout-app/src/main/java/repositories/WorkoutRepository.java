package repositories;

import model.Workout;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout,Long> {

    @Query("SELECT * FROM workout WHERE user_id = :user_id")
    List<Workout> findByUserId(Long user_id);

    @Query("SELECT * FROM workout WHERE workout_id = :workout_id")
    Workout findByWorkoutId(Long workout_id);

    @Modifying
    @Query("INSERT INTO workout (workout_name, user_id) VALUES (:workout_name, :user_id)")
    void insertWorkout(String workout_name, Long user_id);

    @Modifying
    @Query("DELETE FROM workout WHERE workout_id = :workout_id")
    void deleteWorkout(long workout_id);

    @Modifying
    @Query("UPDATE workout SET workout_name = :workout_name WHERE workout_id = :workout_id")
    void editWorkoutName(String workout_name, long workout_id);
}
