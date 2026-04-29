package project.todolist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.todolist.dto.TaskRequestDto;
import project.todolist.dto.TaskResponseDto;
import project.todolist.entity.Task;
import project.todolist.mapping.TaskMapper;
import project.todolist.service.TaskService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;


    @PostMapping
    public TaskResponseDto addTask(@RequestBody TaskRequestDto dto){

        return taskService.addTask(dto);
    }

    @GetMapping
    public List<TaskResponseDto> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    public TaskResponseDto updateTask(@PathVariable Long id, @RequestBody TaskRequestDto dto){
        return taskService.updateTask(id, dto);
    }

    @DeleteMapping("/{id}")
public void deleteTask(@PathVariable  Long id){
       taskService.deleteTask(id);
    }
}
