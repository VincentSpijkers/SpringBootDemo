package nl.hsleiden.ToDos.service;

import nl.hsleiden.ToDos.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class SortService {
    public ArrayList<Task> sortTaskAlphabetically(ArrayList<Task> unsortedTasks){
        ArrayList<Task> sortedTasks = (ArrayList<Task>) unsortedTasks.stream().sorted(Comparator.comparing(Task::getName)).collect(Collectors.toList());
        return sortedTasks;
    }

    public ArrayList<Task> sortTaskByCompleted(ArrayList<Task> unsortedTasks){
        ArrayList<Task> sortedTasks = (ArrayList<Task>) unsortedTasks.stream().sorted(Comparator.comparing(Task::isDone)).collect(Collectors.toList());
        return sortedTasks;
    }
}
