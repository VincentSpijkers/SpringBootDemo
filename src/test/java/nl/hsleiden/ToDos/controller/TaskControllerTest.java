package nl.hsleiden.ToDos.controller;

import nl.hsleiden.ToDos.DAO.TaskDAO;
import nl.hsleiden.ToDos.model.ApiResponse;
import nl.hsleiden.ToDos.model.Task;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskControllerTest {

    private TaskController taskController;
    @Mock
    private TaskDAO taskDAO;

    @Before
    public void setup(){
        taskController = new TaskController(taskDAO);
    }

    @Test
    public void should_returnCorrectSizeOfTaskList_when_listHasOneItem(){
        //Arrange
        int expectedResult = 1;

        Task dummyTask = new Task();
        ArrayList<Task> dummyTasks = new ArrayList<>();
        dummyTasks.add(dummyTask);

        when(this.taskDAO.getAllTasksSortedByName()).thenReturn(dummyTasks);

        //Act
        int actualResult = this.taskController.getTasks().getPayload().size();

        //Assert
        assertEquals(expectedResult, actualResult);
        verify(this.taskDAO, times(1)).getAllTasksSortedByName();

    }

    @Test
    public void should_returnErrorMessage_when_taskWithIdOneDoesNotExists(){
        //Arrange
        int taskId = 1;
        ApiResponse<Task> expectedResult = new ApiResponse(HttpStatus.NOT_FOUND, "Geen task met dat id");

        when(this.taskDAO.getById(taskId)).thenReturn(Optional.empty());

        //Act
        ApiResponse actualResult = this.taskController.getTaskByID(taskId);

        //Assert
        assertEquals(expectedResult.getMessage(), actualResult.getMessage());
        verify(this.taskDAO, times(1)).getById(taskId);
    }

    @Test
    public void should_return404StatusCode_when_taskWithIdOneDoesNotExists(){
        //Arrange
        int taskId = 1;
        ApiResponse expectedResult = new ApiResponse(HttpStatus.NOT_FOUND, "Geen task met dat id");

        when(this.taskDAO.getById(taskId)).thenReturn(Optional.empty()); //STUBBING

        //Act
        ApiResponse actualResult = this.taskController.getTaskByID(taskId);

        //Assert
        assertEquals(expectedResult.getCode(), actualResult.getCode());
        verify(this.taskDAO, times(1)).getById(taskId);
    }

    @Test
    public void should_returnCorrectTask_when_idIsOne(){
        //Arrange
        int taskId = 1;
        Task dummyTask = new Task();
        Task expectedResult = dummyTask;

        when(this.taskDAO.getById(taskId)).thenReturn(Optional.of(dummyTask));

        //Act
        ApiResponse actualResult = this.taskController.getTaskByID(taskId);

        //Assert
        assertEquals(Optional.of(expectedResult), actualResult.getPayload());

    }

    @Test
    public void should_returnCorrectMessage_when_taskDescriptionIsUpdated(){
        String expectedResult = "You updated task: 1 successfully.";
        Task dummyTask = new Task();
        dummyTask.setId(1L);

        Mockito.doNothing().when(this.taskDAO).updateTaskDescription(any());
        ApiResponse actualResult = this.taskController.updateTaskDescription(dummyTask);

        assertThat(expectedResult, is(actualResult.getMessage()));
    }

}