package com.selcen.patika.service;


import com.selcen.patika.dto.*;
import com.selcen.patika.entity.UserEntity;
import com.selcen.patika.repository.IUserRepository;
import com.selcen.patika.repository.TaskRepository;
import com.selcen.patika.entity.Task;
import org.apache.catalina.valves.HealthCheckValve;
import org.springframework.beans.*;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;
import com.selcen.patika.enumer.TaskStatus;
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private IUserRepository userRepository;


    public ResponseEntity<UserDtoR> createUser(UserDtoIU userDtoIU){
        UserEntity user = new UserEntity();
        UserDtoR userDtoR = new UserDtoR();
        BeanUtils.copyProperties(userDtoIU,user);
        userRepository.save(user);
        BeanUtils.copyProperties(user,userDtoR);
        return ResponseEntity.ok(userDtoR);
    }

    public ResponseEntity<List<UserDtoR>> getAllUsers(){
        List<UserEntity> list = userRepository.findAll();
        List<UserDtoR> result = new ArrayList<>();
        for(UserEntity u : list){
            UserDtoR userDtoR = new UserDtoR();
            BeanUtils.copyProperties(u,userDtoR);
            result.add(userDtoR);
        }
        return ResponseEntity.ok(result);
    }



    public ResponseEntity<TaskDtoR> addTaskToUser(Long id,TaskDtoIU taskDtoIU){
        UserEntity user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found!"));
        Task task = new Task();
        TaskDtoR taskDtoR = new TaskDtoR();
        BeanUtils.copyProperties(taskDtoIU,task);
        task.setUser(user);
        taskRepository.save(task);
        BeanUtils.copyProperties(task,taskDtoR);
        return ResponseEntity.ok(taskDtoR);
    }
    public ResponseEntity<List<TaskDtoR>> getTasksByUserId(Long id){
        List<Task> list = taskRepository.findByUserId(id);
        List<TaskDtoR> result = new ArrayList<>();
        for (Task t : list){
            TaskDtoR taskDtoR = new TaskDtoR();
            BeanUtils.copyProperties(t,taskDtoR);
            result.add(taskDtoR);
        }
        return ResponseEntity.ok(result);


    }


    public ResponseEntity<List<TaskDtoR>> getTasksByStatus(TaskStatus taskStatus){
        List<Task> task = taskRepository.findByStatus(taskStatus);
        List<TaskDtoR> result = new ArrayList<>();
        for(Task t: task){
            TaskDtoR taskDtoR = new TaskDtoR();
            BeanUtils.copyProperties(t,taskDtoR);
            result.add(taskDtoR);
        }
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<List<TaskDtoR>> getAllTasks(){
        List<Task> l = taskRepository.findAll();
        List<TaskDtoR> result = new ArrayList<>();
        for (Task t : l ){
            TaskDtoR taskDtoR = new TaskDtoR();
            BeanUtils.copyProperties(t,taskDtoR);
            result.add(taskDtoR);
        }
        return ResponseEntity.ok(result);
    }
}
