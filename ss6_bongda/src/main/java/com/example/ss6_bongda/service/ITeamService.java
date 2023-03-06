package com.example.ss6_bongda.service;

import com.example.ss6_bongda.model.Team;
import com.example.ss6_bongda.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ITeamService {
    List<Team> findAll();
}
