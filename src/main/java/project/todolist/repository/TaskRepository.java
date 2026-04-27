package project.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.todolist.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
