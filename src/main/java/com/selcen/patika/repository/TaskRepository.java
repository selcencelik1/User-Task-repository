package com.selcen.patika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.selcen.patika.entity.Task;
import java.util.List;
import com.selcen.patika.enumer.TaskStatus;


public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByUserId(Long userId);
    List<Task> findByStatus(TaskStatus status);
}
