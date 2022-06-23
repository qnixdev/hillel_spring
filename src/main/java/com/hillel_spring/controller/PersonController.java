package com.hillel_spring.controller;

import com.hillel_spring.model.Person;
import com.hillel_spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody Person get(@PathVariable Integer id) {
        return this.personService.read(id);
    }

    @PostMapping(produces = "application/json")
    public @ResponseBody boolean update(@RequestBody Person person) {
        return this.personService.update(person);
    }

    @PutMapping(produces = "application/json")
    public @ResponseBody Person create(@RequestBody Person person) {
        return this.personService.create(person);
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody void delete(@PathVariable Integer id) {
        this.personService.delete(id);
    }
}