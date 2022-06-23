package com.hillel_spring.service;

import com.hillel_spring.model.Animal;
import com.hillel_spring.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final PersonService personService;

    @Autowired
    public AnimalService(AnimalRepository animalRepository, PersonService personService) {
        this.animalRepository = animalRepository;
        this.personService = personService;
    }

    public Animal create(Animal animal, Integer ownerId) {
        var owner = Optional.of(this.personService.read(ownerId));
        owner.ifPresent(animal::setOwner);
        this.animalRepository.save(animal);

        return animal;
    }

    public Animal read(Integer id) {
        return this.animalRepository.findById(id).orElse(null);
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

        if (isHasChangeInEntity) {
            this.animalRepository.save(existAnimal);
        }

        return isHasChangeInEntity;
    }

    public void delete(Integer id) {
        this.animalRepository.deleteById(id);
    }
}