package project.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskRequestDto {
    @NotBlank(message = "Title cannot be empty")
    String title;
   String description;
boolean completed;

}
