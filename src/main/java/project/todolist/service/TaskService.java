package project.todolist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.todolist.entity.Task;
import project.todolist.repository.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

private final TaskRepository repo;

public List<Task> getAllTasks(){
    return repo.findAll();
}

    public Task addTask(Task task) {
    return repo.save(task);
    }
    public  Task updateTask(Long id, Task updatedTask){
    Task task = repo.findById(id)
            .orElseThrow(()-> new RuntimeException("Task not found"));
    task.setTitle(updatedTask.getTitle());
    task.setCompleted(updatedTask.isCompleted());
    return repo.save(task);
    }
    public void deleteTask(Long id){
    repo.deleteById(id);
    }
}
