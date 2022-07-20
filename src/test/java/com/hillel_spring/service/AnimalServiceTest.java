package com.hillel_spring.service;

import com.hillel_spring.model.Animal;
import com.hillel_spring.model.Person;
import com.hillel_spring.repository.AnimalRepository;
import com.hillel_spring.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;

public class AnimalServiceTest {
    private final PersonRepository personRepository = Mockito.mock(PersonRepository.class);
    private final AnimalRepository animalRepository = Mockito.mock(AnimalRepository.class);
    private final PersonService personService = new PersonService(this.personRepository);
    private final AnimalService animalService = new AnimalService(this.animalRepository, this.personService);

    @Test
    public void testCreate() {
        var dogOwner = Person.builder().id(333).name("Mykola").build();
        var dog = Animal.builder()
            .id(123)
            .name("Pitbull")
            .person(dogOwner)
            .build()
        ;

        Mockito
            .when(this.personRepository.findById(Mockito.anyInt()))
            .thenReturn(Optional.of(dogOwner))
        ;
        Mockito
            .when(this.animalRepository.save(Mockito.any()))
            .thenReturn(dog)
        ;

        Assertions.assertEquals(dog, this.animalService.create(dog));
        Mockito.verify(this.personRepository).findById(Mockito.anyInt());
        Mockito.verify(this.animalRepository).save(dog);
    }

    @Test
    public void testRead() {
        var dog = Animal.builder()
            .id(123)
            .name("Pitbull")
            .person(Person.builder().id(333).name("Mykola").build())
            .build()
        ;

        Mockito
            .when(this.animalRepository.findById(Mockito.anyInt()))
            .thenReturn(Optional.of(dog))
        ;

        Assertions.assertEquals(dog, this.animalService.read(Mockito.anyInt()));
        Mockito.verify(this.animalRepository).findById(Mockito.anyInt());
    }

    @Test
    public void testUpdate() {
        var receivedDog = Animal.builder()
            .id(123)
            .name("Pitbull")
            .person(Person.builder().id(6).name("Mykola").build())
            .build()
        ;
        var existDog = Animal.builder()
            .id(123)
            .name("Pitbull")
            .person(Person.builder().id(777).name("Mykola").build())
            .build()
        ;

        Mockito
            .when(this.animalRepository.findById(Mockito.any()))
            .thenReturn(Optional.of(existDog))
        ;

        Assertions.assertTrue(this.animalService.update(receivedDog));
        Mockito.verify(this.animalRepository).save(receivedDog);
    }

    @Test
    public void testDelete() {
        var dog = Animal.builder()
            .id(123)
            .name("Pitbull")
            .person(Person.builder().id(6).name("Mykola").build())
            .build()
        ;

        this.animalService.delete(dog.getId());

        Mockito.verify(this.animalRepository).deleteById(Mockito.anyInt());
    }
}