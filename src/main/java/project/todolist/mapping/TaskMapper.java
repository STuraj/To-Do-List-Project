package project.todolist.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import project.todolist.dto.TaskRequestDto;
import project.todolist.dto.TaskResponseDto;
import project.todolist.entity.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity(TaskRequestDto dto);

    TaskResponseDto toDto(Task task);

    void updateTaskFromDto(TaskRequestDto dto, @MappingTarget Task task);
}
