package com.hillel_spring.controller;

import com.hillel_spring.model.Animal;
import com.hillel_spring.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animal")
public class AnimalController {
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/{id}")
    public @ResponseBody Animal get(@PathVariable Integer id) {
        return this.animalService.read(id);
    }

    @PutMapping(produces = "application/json")
    public @ResponseBody Animal create(@RequestBody Animal animal, Integer ownerId) {
        return this.animalService.create(animal, ownerId);
    }

    @PostMapping(produces = "application/json")
    public @ResponseBody boolean update(@RequestBody Animal animal) {
        return this.animalService.update(animal);
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody void delete(@PathVariable Integer id) {
        this.animalService.delete(id);
    }
}