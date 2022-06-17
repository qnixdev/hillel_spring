package com.hillel_spring.service;

import com.hillel_spring.model.Animal;
import com.hillel_spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    private final PersonService personService;

    @Autowired
    public AnimalService(PersonService personService) {
        this.personService = personService;
    }

    public Animal create(String animalName, Person owner) {
        return Animal.builder()
            .name(animalName)
            .owner(owner)
            .build()
        ;
    }

    public Animal read(Integer id) {
        //TODO: get entity from db

        return Animal.builder()
            .name("Norka")
            .owner(this.personService.create("My"))
            .build()
        ;
    }

    public boolean update(Animal animal, String animalName, Person owner) {
        boolean isHasChangeInEntity = false;

        if (!animal.getName().equals(animalName)) {
            animal.setName(animal.getName());
            isHasChangeInEntity = true;
        }

        if (!animal.getOwner().equals(owner)) {
            animal.setOwner(owner);
            isHasChangeInEntity = true;
        }

        return isHasChangeInEntity;
    }

    public void delete(Integer id) {
        var animal = this.read(id);

        //TODO: remove from db
    }
}