package nl.hsleiden.ToDos.controller;

import nl.hsleiden.ToDos.DAO.TaskDAO;
import nl.hsleiden.ToDos.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping(value = "/api/tasks")
public class TaskController {

    private final TaskDAO taskDAO;

    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public String postTask(@RequestBody Task task){
        this.taskDAO.saveToDatabase(task);
        return "You created a task!";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Task> getTasks(){
        ArrayList<Task> tasks = this.taskDAO.getAll();
        return tasks;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Task> getTaskByID(@PathVariable long id){
        return this.taskDAO.getById(id);
    }


}
