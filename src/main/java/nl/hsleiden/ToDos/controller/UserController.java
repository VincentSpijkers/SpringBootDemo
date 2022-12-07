package nl.hsleiden.ToDos.controller;

import nl.hsleiden.ToDos.model.ApiResponse;
import nl.hsleiden.ToDos.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/api/user")
public class UserController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse<ArrayList<Task>> getTestResponse(){
        return new ApiResponse<ArrayList<Task>>(HttpStatus.ACCEPTED, "Test response!");
    }
}
