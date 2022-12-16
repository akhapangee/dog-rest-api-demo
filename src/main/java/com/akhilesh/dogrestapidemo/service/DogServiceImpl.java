package com.akhilesh.dogrestapidemo.service;

import com.akhilesh.dogrestapidemo.entity.Dog;
import com.akhilesh.dogrestapidemo.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {
    private DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }
    @Override
    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalDog = Optional.ofNullable(dogRepository.findDogBreedById(id));
        String breed = optionalDog.orElseThrow(DogNotFoundException::new);
        return breed;
    }

    @Override
    public List<String> retrieveDogBreed() {
        return dogRepository.findAllBreed();
    }

    @Override
    public List<String> retrieveDogNames() {
        return dogRepository.findAllNames();
    }
}
