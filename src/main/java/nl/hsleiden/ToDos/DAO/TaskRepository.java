package nl.hsleiden.ToDos.DAO;

import nl.hsleiden.ToDos.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
