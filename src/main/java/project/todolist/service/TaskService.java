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
    @Autowired
private final TaskRepository repo;

public List<Task> getAllTasks(){
    return repo.findAll();
}

//    public Task getTasksById(long id) {
//    return repo.findById(id);
//    }

    public Task addTask(Task task) {
    return repo.save(task);
    }
    public void deleteTask(Long id){
    repo.deleteById(id);
    }
}
