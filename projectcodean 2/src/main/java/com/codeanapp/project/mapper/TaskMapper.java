package com.codeanapp.project.mapper;

import com.codeanapp.project.dto.TaskUpdateDto;
import com.codeanapp.project.model.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper {

    void insertTask(Task task);

    List<Task> getAllTask();

    void updateTask(TaskUpdateDto taskUpdateDto);

    void deleteTask(String idtask);
}
