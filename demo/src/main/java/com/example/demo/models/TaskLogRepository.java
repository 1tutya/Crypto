package com.example.demo.models;

import org.springframework.data.repository.CrudRepository;

public interface TaskLogRepository extends CrudRepository<TaskLog, Long> {
}