package com.selcen.patika.dto;

import com.selcen.patika.entity.Task;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoIU {
    private Long id;


    @NotBlank(message = "Name cannot be empty.")
    private String name;

    @NotBlank(message = "Email cannot be empty.")
    private String email;


    private List<Task> taskList;

}
