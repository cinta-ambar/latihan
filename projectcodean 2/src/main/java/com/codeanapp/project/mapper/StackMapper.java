package com.codeanapp.project.mapper;

import com.codeanapp.project.model.Stack;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StackMapper {

    void insertStack(Stack stack);

    List<Stack> getAllStack();

    void deleteStack(String idstcak);

}
