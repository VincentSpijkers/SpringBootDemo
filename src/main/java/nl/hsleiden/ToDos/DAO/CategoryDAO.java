package nl.hsleiden.ToDos.DAO;

import nl.hsleiden.ToDos.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CategoryDAO {

    private final CategoryRepository categoryRepository;

    public CategoryDAO(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void saveToDatabase(Category category){
        this.categoryRepository.save(category);
    }

    public ArrayList<Category> getAll(){
        return (ArrayList<Category>) this.categoryRepository.findAll();
    }

}
