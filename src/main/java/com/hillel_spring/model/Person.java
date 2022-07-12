package com.hillel_spring.model;

import lombok.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", length = 63, nullable = false)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Animal> animals;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }

    public void addAnimal(Animal animal) {
        if (!this.animals.contains(animal)) {
            this.animals.add(animal);
            animal.setPerson(this);
        }
    }

    public void removeAnimal(Animal animal) {
        if (this.animals.remove(animal)) {
            if (animal.getPerson() == this) {
                animal.setPerson(null);
            }
        }
    }
}