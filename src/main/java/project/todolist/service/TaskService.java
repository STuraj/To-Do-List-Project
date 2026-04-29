package project.todolist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.todolist.dto.TaskRequestDto;
import project.todolist.dto.TaskResponseDto;
import project.todolist.entity.Task;
import project.todolist.mapping.TaskMapper;
import project.todolist.repository.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

private final TaskRepository repo;
private final TaskMapper mapper;

public List<TaskResponseDto> getAllTasks(){
    return repo.findAll()
            .stream()
            .map(mapper::toDto)
            .toList();
}

    public TaskResponseDto addTask(TaskRequestDto dto) {
    Task task = mapper.toEntity(dto);
    Task saved = repo.save(task);

    return mapper.toDto(saved);

    }

    public  TaskResponseDto updateTask(Long id, TaskRequestDto dto){

    Task task = repo.findById(id)
            .orElseThrow(()-> new RuntimeException("Task not found"));

    mapper.updateTaskFromDto(dto, task);

    return mapper.toDto(repo.save(task));
    }

    public void deleteTask(Long id){
    repo.deleteById(id);
    }
}
