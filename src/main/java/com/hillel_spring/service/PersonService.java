package com.hillel_spring.service;

import com.hillel_spring.model.Person;
import com.hillel_spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(Person person) {
        this.personRepository.save(person);

        return person;
    }

    public Person read(Integer id) {
        return this.personRepository.findById(id).orElse(null);
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

        if (isHasChangeInEntity) {
            this.personRepository.save(existPerson);
        }

        return isHasChangeInEntity;
    }

    public void delete(Integer id) {
        this.personRepository.deleteById(id);
    }
}