package com.hillel_spring.model;

import lombok.Builder;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Collection;

@Builder
@ToString
public class Person {
    @Id
    private Integer id;
    private String name;
    private Collection<Animal> animals;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Animal> getAnimals() {
        return this.animals;
    }

    public void addAnimal(Animal animal) {
        if (!this.animals.contains(animal)) {
            this.animals.add(animal);
            animal.setOwner(this);
        }
    }

    public void removeAnimal(Animal animal) {
        if (this.animals.remove(animal)) {
            if (animal.getOwner() == this) {
                animal.setOwner(null);
            }
        }
    }
}