package repositories;

import model.WorkoutSet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutSetRepository extends CrudRepository<WorkoutSet,Long> {
}
