package com.hillel_spring.controller;

import com.hillel_spring.model.Person;
import com.hillel_spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public Person get(@PathVariable Integer id) {
        return this.personService.read(id);
    }

    @PutMapping
    public Person create(@RequestBody Person person) {
        return this.personService.create(person);
    }

    @PostMapping
    public boolean update(@RequestBody Person person) {
        return this.personService.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.personService.delete(id);
    }
}