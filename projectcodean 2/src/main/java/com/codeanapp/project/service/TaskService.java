package com.codeanapp.project.service;

import com.codeanapp.project.dto.TaskUpdateDto;
import com.codeanapp.project.mapper.TaskMapper;
import com.codeanapp.project.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    public void insertTask(Task task){
        if (task.getIdtask() == null || task.getIdtask().isEmpty()){
            task.setIdtask(UUID.randomUUID().toString());
        }
        taskMapper.insertTask(task);
    }

    public List<Task> getAllTask(){
        return taskMapper.getAllTask();
    }

    public void updateTask(TaskUpdateDto taskUpdateDto){
        taskMapper.updateTask(taskUpdateDto);
    }

    public void deleteTask(String idtask){
        taskMapper.deleteTask(idtask);
    }
}

