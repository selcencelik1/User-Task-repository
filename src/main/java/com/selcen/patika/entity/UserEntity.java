package com.selcen.patika.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "user")
    private List<Task> taskList;
}
