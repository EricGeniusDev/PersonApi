package dev.dojo.personapi.service;

import java.util.List;

import dev.dojo.personapi.models.Person;

public interface PersonService {

    List<Person> findAllPersons();

    Person findPersonById(Long id);

    void savePerson(Person person);

    void updatePerson(Person person);
}
