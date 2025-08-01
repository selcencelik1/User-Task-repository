package com.selcen.patika.dto;

import com.selcen.patika.entity.Task;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoR {
    private String name;

    private String email;

    private List<Task> taskList;
}
