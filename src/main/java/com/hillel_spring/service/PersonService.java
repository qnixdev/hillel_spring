package com.hillel_spring.service;

import com.hillel_spring.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    public Person create(Person person) {
        //TODO: save entity on db

        return person;
    }

    public Person read(Integer id) {
        //TODO: get entity from db

        return Person.builder()
            .name("My")
            .build()
        ;
    }

    public boolean update(Person receivedPerson) {
        var existPerson = this.read(receivedPerson.getId());

        if (null == existPerson) {
            return false;
        }

        boolean isHasChangeInEntity = false;

        if (!existPerson.getName().equals(receivedPerson.getName())) {
            existPerson.setName(receivedPerson.getName());
            isHasChangeInEntity = true;
        }

        //TODO: save change in entity on db

        return isHasChangeInEntity;
    }

    public void delete(Integer id) {
        var person = this.read(id);

        //TODO: remove entity from db
    }
}