package com.hillel_spring.controller;

import com.hillel_spring.model.Animal;
import com.hillel_spring.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/{id}")
    public Animal get(@PathVariable Integer id) {
        return this.animalService.read(id);
    }

    @PutMapping
    public Animal create(@RequestBody Animal animal) {
        return this.animalService.create(animal);
    }

    @PostMapping
    public boolean update(@RequestBody Animal animal) {
        return this.animalService.update(animal);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.animalService.delete(id);
    }
}