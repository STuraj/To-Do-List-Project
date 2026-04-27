package project.todolist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.todolist.entity.Task;
import project.todolist.service.TaskService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/{taskId}/ add")
    public Task addTask(@RequestBody Task task){

        return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }
    @DeleteMapping("/{id}")
public void deleteTask(@PathVariable  Long id){
       taskService.deleteTask(id);
    }
}
