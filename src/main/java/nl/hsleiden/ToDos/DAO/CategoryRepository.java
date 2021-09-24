package nl.hsleiden.ToDos.DAO;

import nl.hsleiden.ToDos.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
