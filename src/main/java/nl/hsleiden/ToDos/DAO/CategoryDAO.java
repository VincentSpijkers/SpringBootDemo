package nl.hsleiden.ToDos.DAO;

import nl.hsleiden.ToDos.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDAO {

    private final CategoryRepository categoryRepository;

    public CategoryDAO(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void saveToDatabase(Category category){
        this.categoryRepository.save(category);
    }

    public List<Category> getAll(){
        return this.categoryRepository.findAll();
    }

}
