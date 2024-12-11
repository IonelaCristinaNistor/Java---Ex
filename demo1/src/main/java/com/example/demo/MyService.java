package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {
    @Autowired
    private MaltaRepository commentRepository;

    // Autowire the other two repositories

    public void readData() {
        List<Malta> comments = commentRepository.findAll();
        // Use the other two repositories to read data from the other two tables
    }
}
