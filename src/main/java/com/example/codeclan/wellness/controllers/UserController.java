package com.example.codeclan.wellness.controllers;

import com.example.codeclan.wellness.models.Submission;
import com.example.codeclan.wellness.models.User;
import com.example.codeclan.wellness.repositories.SubmissionRepository;
import com.example.codeclan.wellness.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SubmissionRepository submissionRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping(value = "/users/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}/submissions")
    public ResponseEntity<List<Submission>> getSubmissions(@PathVariable Long id){
        return new ResponseEntity<>(submissionRepository.findByUserId(id), HttpStatus.OK);
    }

}
