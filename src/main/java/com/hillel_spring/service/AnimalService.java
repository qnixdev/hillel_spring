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

    public Animal create(Animal animal, Integer ownerId) {
        var owner = this.personService.read(ownerId);
        animal.setOwner(owner);

        //TODO: save entity on db

        return animal;
    }

    public Animal read(Integer id) {
        //TODO: get entity from db

        return Animal.builder()
            .name("Norka")
            .owner(Person.builder().name("My").build())
            .build()
        ;
    }

    public boolean update(Animal receivedAnimal) {
        var existAnimal = this.read(receivedAnimal.getId());

        if (null == existAnimal) {
            return false;
        }

        boolean isHasChangeInEntity = false;

        if (!existAnimal.getName().equals(receivedAnimal.getName())) {
            existAnimal.setName(receivedAnimal.getName());
            isHasChangeInEntity = true;
        }

        if (!existAnimal.getOwner().equals(receivedAnimal.getOwner())) {
            existAnimal.setOwner(receivedAnimal.getOwner());
            isHasChangeInEntity = true;
        }

        //TODO: save change in entity on db

        return isHasChangeInEntity;
    }

    public void delete(Integer id) {
        var animal = this.read(id);

        //TODO: remove entity from db
    }
}