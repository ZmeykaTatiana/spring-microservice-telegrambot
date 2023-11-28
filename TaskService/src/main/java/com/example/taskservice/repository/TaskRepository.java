package com.example.taskservice.repository;

import com.example.taskservice.model.Task1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task1,Integer> {
    @Override
    Optional<Task1> findById(Integer user);
}
