package nl.hsleiden.ToDos.DAO;

import nl.hsleiden.ToDos.model.Task;
import nl.hsleiden.ToDos.service.SortService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class TaskDAO {

    private final TaskRepository taskRepository;
    private final SortService sortService;

    public TaskDAO(TaskRepository taskRepository, SortService sortService) {
        this.sortService = sortService;
        this.taskRepository = taskRepository;
    }

    public void saveToDatabase(Task task){
        this.taskRepository.save(task);
    }

    public ArrayList<Task> getAllTasksSortedByName(){
        ArrayList<Task> tasks = (ArrayList<Task>) this.taskRepository.findAll();
        return this.sortService.sortTaskAlphabetically(tasks);
    }

    public ArrayList<Task> getAllTasksSortedByDone(){
        ArrayList<Task> tasks = (ArrayList<Task>) this.taskRepository.findAll();
        return this.sortService.sortTaskByCompleted(tasks);
    }

    public Optional<Task> getById(long id){
        return this.taskRepository.findById(id);
    }
}
