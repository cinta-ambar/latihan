package com.codeanapp.project.service;

import com.codeanapp.project.mapper.StackMapper;
import com.codeanapp.project.model.Stack;
import com.codeanapp.project.model.enumm.StackEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StackService {

    @Autowired
    private StackMapper stackMapper;

    public void insertStack(Stack stack){
        if (stack.getIdstack() == null || stack.getIdstack().isEmpty()){
            stack.setIdstack(UUID.randomUUID().toString());
        }
        String pilihan = stack.getNamastack().toLowerCase();
        switch (pilihan){
            case "a":
                String a = StackEnum.FRONT_END.getMessage();
                stack.setNamastack(a);
                break;
            case "b" :
                String b = StackEnum.BACK_END.getMessage();
                stack.setNamastack(b);
                break;
            default:
                String c = "pilihan tidak tersedia";
                stack.setNamastack(c);
        }
        stackMapper.insertStack(stack);
    }

    public List<Stack> getAllStack(){
        return stackMapper.getAllStack();
    }

    public void deleteStack(String idstack){
        stackMapper.deleteStack(idstack);
    }
}
