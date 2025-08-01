package com.selcen.patika.controller;

import com.selcen.patika.dto.TaskDtoIU;
import com.selcen.patika.dto.TaskDtoR;
import com.selcen.patika.dto.UserDtoIU;
import com.selcen.patika.dto.UserDtoR;
import com.selcen.patika.enumer.TaskStatus;
import com.selcen.patika.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping("/{id}")
    public ResponseEntity<TaskDtoR> createTask(@PathVariable Long id,@RequestBody @Valid TaskDtoIU taskDtoIU){
        return taskService.addTaskToUser(id,taskDtoIU);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TaskDtoR>> getTasks(@PathVariable Long id){
        return taskService.getTasksByUserId(id);
    }

    @GetMapping
    public ResponseEntity<List<TaskDtoR>> getTasksByStatus(@RequestParam(required = false) TaskStatus status){
        if(status!= null) return taskService.getTasksByStatus(status);
        return taskService.getAllTasks();
        }

}


