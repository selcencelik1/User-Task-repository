package com.selcen.patika.dto;
import com.selcen.patika.enumer.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.validation.*;

@NoArgsConstructor
@AllArgsConstructor
@Data


public class TaskDtoIU {
    private Long id;

    @NotBlank(message = "Title cannot be empty.")
    private String title;

    @NotBlank(message = "Description cannot be empty.")
    private String description;

    @NotNull(message = "Status must be chosen.")
    private TaskStatus status;


}
