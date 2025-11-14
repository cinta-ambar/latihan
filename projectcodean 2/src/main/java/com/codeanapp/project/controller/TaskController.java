package com.codeanapp.project.controller;

import com.codeanapp.project.dto.TaskUpdateDto;
import com.codeanapp.project.model.Task;
import com.codeanapp.project.model.response.ApiResponse;
import com.codeanapp.project.model.response.ResponseMessage;
import com.codeanapp.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/addtask")
    public ResponseEntity<ApiResponse<Object>> insertTask(Task task){
        taskService.insertTask(task);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), null));
    }

    @GetMapping("/alltask")
    public ResponseEntity<ApiResponse<Object>> getAllTask(){
        List<Task> data = taskService.getAllTask();
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data));
    }

    @PatchMapping("/updatetask")
    public ResponseEntity<ApiResponse<Object>> updateTask(TaskUpdateDto taskUpdateDto){
        taskService.updateTask(taskUpdateDto);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_MODIFIED.getMessage(), null));
    }

    @DeleteMapping("/deletetask")
    public ResponseEntity<ApiResponse<Object>> deleteTask(String idtask){
        taskService.deleteTask(idtask);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.NO_CONTENT, ResponseMessage.RESOURCE_DELETE.getMessage(), null));
    }
}
