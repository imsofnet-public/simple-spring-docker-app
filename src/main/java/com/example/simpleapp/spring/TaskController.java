package com.example.simpleapp.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public Task postData(@RequestBody Task task){
        return taskRepository.save(task);
    }
    @GetMapping
    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task getOne(@PathVariable Long id){
        return taskRepository.findById(id).orElse(null);
    }
}
