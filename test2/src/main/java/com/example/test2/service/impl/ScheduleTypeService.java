package com.example.test2.service.impl;

import com.example.test2.model.ScheduleType;
import com.example.test2.repository.IScheduleTypeRepository;
import com.example.test2.service.IScheduleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScheduleTypeService implements IScheduleTypeService {
    @Autowired
    private IScheduleTypeRepository scheduleTypeRepository;
    @Override
    public List<ScheduleType> findAll() {
        return scheduleTypeRepository.findAll();
    }
}
