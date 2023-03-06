package com.example.test2.repository;

import com.example.test2.model.ScheduleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IScheduleTypeRepository extends JpaRepository<ScheduleType, Integer> {
}
