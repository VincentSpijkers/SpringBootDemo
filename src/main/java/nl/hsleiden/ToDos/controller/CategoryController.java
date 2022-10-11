package nl.hsleiden.ToDos.controller;
import nl.hsleiden.ToDos.DAO.CategoryDAO;
import nl.hsleiden.ToDos.model.ApiResponse;
import nl.hsleiden.ToDos.model.Category;
import nl.hsleiden.ToDos.service.SortService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@Controller
@RequestMapping(value = "/api/category")
public class CategoryController {

    private final SortService sortService;
    private final CategoryDAO categoryDAO;

    public CategoryController(SortService sortService, CategoryDAO categoryDAO) {
        this.sortService = sortService;
        this.categoryDAO = categoryDAO;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse postCategories(@RequestBody Category category){
        //seervice 
        this.categoryDAO.saveToDatabase(category);
        return new ApiResponse(HttpStatus.ACCEPTED, "You posted some data!");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse<ArrayList<Category>> categories(){
        ArrayList<Category> categories = this.categoryDAO.getAll();
        return new ApiResponse(HttpStatus.ACCEPTED, categories);
    }
}
