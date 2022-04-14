package dev.dojo.personapi.service;

import java.util.List;

import dev.dojo.personapi.dto.request.PersonDto;
import dev.dojo.personapi.models.Person;

public interface PersonService {

    List<Person> findAllPersons();

    Person findPersonById(Long id);

    Person savePerson(PersonDto person);

    Person updatePerson(Long id, PersonDto person);

    void delete(Long id);
}
