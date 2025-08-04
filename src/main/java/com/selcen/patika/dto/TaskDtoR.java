package com.selcen.patika.dto;
import com.selcen.patika.enumer.TaskStatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDtoR {

    private String title;

    private String description;

    private TaskStatus status;

    private Long userId;
}
