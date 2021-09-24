package nl.hsleiden.ToDos.DAO;

import nl.hsleiden.ToDos.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class TaskDAO {

    private TaskRepository taskRepository;

    public TaskDAO(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void saveToDatabase(Task task){
        this.taskRepository.save(task);
    }

    public ArrayList<Task> getAll(){
        ArrayList<Task> tasks = (ArrayList<Task>) this.taskRepository.findAll();
        return tasks;
    }

    public Optional<Task> getById(long id){
        return this.taskRepository.findById(id);
    }
}
