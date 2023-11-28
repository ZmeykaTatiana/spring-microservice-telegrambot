package com.example.taskservice.controller;

import com.example.taskservice.model.Task1;
import com.example.taskservice.repository.TaskRepository;
import com.example.userservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/all")
    public List<Task1> showAll(){
        List<Task1> tasks=taskRepository.findAll();
        return tasks;
    }


    @PostMapping("/add")
    public Task1 createTask(@RequestBody Task1 task){
     return taskRepository.save(task);
    }

    @GetMapping("/task/{id}")
    public Task1 one(@PathVariable int id){
        return taskRepository.findById(id).orElse(null);
    }

    @GetMapping("/{taskId}")
    public User getUser(@PathVariable int taskId) {
        Task1 task = taskRepository.findById(taskId).orElse(null);
        User user = restTemplate.getForObject("http://localhost:8087/user/{id}", User.class, task.getUserId());
        return user;
    }



}
