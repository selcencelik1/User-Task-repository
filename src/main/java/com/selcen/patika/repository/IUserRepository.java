package com.selcen.patika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.selcen.patika.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity,Long> {
}
