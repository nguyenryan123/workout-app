package repositories;

import model.Workout;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout,Long> {

    @Query("SELECT * FROM workout WHERE user_id = :user_id")
    List<Workout> findByUserId(Long user_id);
}
