package com.selcen.patika.controller;


import com.selcen.patika.dto.UserDtoIU;
import com.selcen.patika.dto.UserDtoR;
import com.selcen.patika.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<UserDtoR>> getAllUsers(){
        return taskService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<UserDtoR> createUser( @RequestBody @Valid UserDtoIU userDtoIU){
        return taskService.createUser(userDtoIU);
    }
}
