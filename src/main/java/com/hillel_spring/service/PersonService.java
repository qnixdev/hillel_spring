package com.hillel_spring.service;

import com.hillel_spring.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    public Person create(String name) {
        return Person.builder()
            .name(name)
            .build()
        ;
    }

    public Person read(Integer id) {
        //TODO: get entity from db

        return Person.builder()
            .name("My")
            .build()
        ;
    }

    public boolean update(Person person, String name) {
        boolean isHasChangeInEntity = false;

        if (!person.getName().equals(name)) {
            person.setName(name);
            isHasChangeInEntity = true;
        }

        return isHasChangeInEntity;
    }

    public void delete(Integer id) {
        var person = this.read(id);

        //TODO: remove from db
    }
}