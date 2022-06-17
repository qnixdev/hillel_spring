package com.hillel_spring.controller;

import com.hillel_spring.model.Animal;
import com.hillel_spring.model.Person;
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

    @PostMapping(produces = "application/json")
    public @ResponseBody boolean update(@RequestBody Animal animal, String name, Person owner) {
        return this.animalService.update(animal, name, owner);
    }

    @PutMapping(produces = "application/json")
    public @ResponseBody Animal create(@RequestBody String name, Person owner) {
        return this.animalService.create(name, owner);
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody void delete(@PathVariable Integer id) {
        this.animalService.delete(id);
    }
}