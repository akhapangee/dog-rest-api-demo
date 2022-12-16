package com.akhilesh.dogrestapidemo.controller;

import com.akhilesh.dogrestapidemo.entity.Dog;
import com.akhilesh.dogrestapidemo.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    private DogService dogService;

    // setter based dependency injection
    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getDogs() {
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getAllDogNames() {
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/{id}/breed")
    public ResponseEntity<String> getDogBreedById(@PathVariable("id") Long id) {
        String dogBreed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<>(dogBreed, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> retrieveDogBreed() {
        List<String> dogBreed = dogService.retrieveDogBreed();
        return new ResponseEntity<>(dogBreed, HttpStatus.OK);
    }

}
