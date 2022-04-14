package dev.dojo.personapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.dojo.personapi.models.Person;
import dev.dojo.personapi.repository.PersonRepository;
import dev.dojo.personapi.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person findPersonById(Long id) {
        return personRepository.findById(id)
                .orElse(null);
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.save(person);
    }

}
