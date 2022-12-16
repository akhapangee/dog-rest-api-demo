package com.akhilesh.dogrestapidemo.service;

import com.akhilesh.dogrestapidemo.entity.Dog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DogService {
    List<Dog> retrieveDogs();

    String retrieveDogBreedById(Long id);

    List<String> retrieveDogBreed();

    List<String> retrieveDogNames();
}
