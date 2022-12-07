package nl.hsleiden.ToDos.controller;
import nl.hsleiden.ToDos.DAO.TaskDAO;
import nl.hsleiden.ToDos.model.ApiResponse;
import nl.hsleiden.ToDos.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/tasks")
public class TaskController {

    private final TaskDAO taskDAO;

    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse postTask(@RequestBody Task task){
        this.taskDAO.saveToDatabase(task);
        return new ApiResponse(HttpStatus.ACCEPTED, "You created a task!");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse updateTaskDescription(@RequestBody Task task){
        this.taskDAO.updateTaskDescription(task);
        return new ApiResponse(HttpStatus.ACCEPTED, "You updated task: " + task.getId() + " successfully.");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse<ArrayList<Task>> getTasks(){
        ArrayList<Task> tasks = this.taskDAO.getAllTasksSortedByName();
        return new ApiResponse<ArrayList<Task>>(HttpStatus.ACCEPTED, tasks);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getTaskByID(@PathVariable long id){
        Optional<Task> task = this.taskDAO.getById(id);
        if (task.isEmpty()){
            return new ApiResponse<Task>(HttpStatus.NOT_FOUND, "Geen task met dat id");
        }

        return new ApiResponse<Optional<Task>>(HttpStatus.ACCEPTED, task);
    }

}
