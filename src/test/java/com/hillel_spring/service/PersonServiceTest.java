package com.hillel_spring.service;

import com.hillel_spring.model.Person;
import com.hillel_spring.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;

public class PersonServiceTest {
    private final PersonRepository personRepository = Mockito.mock(PersonRepository.class);
    private final PersonService personService = new PersonService(this.personRepository);

    @Test
    public void testCreate() {
        var person = Person.builder().id(321).name("Peter").build();

        Mockito
            .when(this.personRepository.save(Mockito.any()))
            .thenReturn(person)
        ;

        Assertions.assertEquals(person, this.personService.create(person));
        Mockito.verify(this.personRepository).save(person);
    }

    @Test
    public void testRead() {
        var person = Person.builder().id(321).name("Peter").build();

        Mockito
            .when(this.personRepository.findById(Mockito.anyInt()))
            .thenReturn(Optional.of(person))
        ;

        Assertions.assertEquals(person, this.personService.read(Mockito.anyInt()));
        Mockito.verify(this.personRepository).findById(Mockito.anyInt());
    }

    @Test
    public void testUpdate() {
        var receivedPerson = Person.builder().id(321).name("Peter").build();
        var existPerson = Person.builder().id(321).name("Peter Parker").build();

        Mockito
            .when(this.personRepository.findById(Mockito.any()))
            .thenReturn(Optional.of(existPerson))
        ;

        Assertions.assertTrue(this.personService.update(receivedPerson));
        Mockito.verify(this.personRepository).save(Mockito.any());
    }

    @Test
    public void testDelete() {
        var person = Person.builder().id(321).name("Peter").build();

        this.personService.delete(person.getId());

        Mockito.verify(this.personRepository).deleteById(Mockito.anyInt());
    }
}