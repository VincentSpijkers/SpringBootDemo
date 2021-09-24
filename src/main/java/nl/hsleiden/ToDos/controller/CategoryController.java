package nl.hsleiden.ToDos.controller;
import nl.hsleiden.ToDos.DAO.CategoryDAO;
import nl.hsleiden.ToDos.model.Category;
import nl.hsleiden.ToDos.service.SortService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/api/categories")
public class CategoryController {

    private final SortService sortService;
    private final CategoryDAO categoryDAO;

    public CategoryController(SortService sortService, CategoryDAO categoryDAO) {
        this.sortService = sortService;
        this.categoryDAO = categoryDAO;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public String postCategories(@RequestBody Category category){
        this.categoryDAO.saveToDatabase(category);
        return "You posted some data!";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> categories(){
        return this.categoryDAO.getAll();
    }
}
