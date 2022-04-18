package dev.dojo.personapi.service.impl;

import java.util.List;

import dev.dojo.personapi.exceptions.PersonAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.dojo.personapi.dto.mapper.PersonMapper;
import dev.dojo.personapi.dto.request.PersonDto;
import dev.dojo.personapi.dto.response.PersonResponse;
import dev.dojo.personapi.exceptions.PersonNotFoundException;
import dev.dojo.personapi.models.Person;
import dev.dojo.personapi.repository.PersonRepository;
import dev.dojo.personapi.service.PersonService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person findPersonById(Long id) {
        return findPerson(id);
    }

    @Override
    @Transactional
    public PersonResponse savePerson(PersonDto personDto) {
        var personIsPresent = personRepository.findById(personDto.getId()).isPresent();
        if(personIsPresent)
            throw new PersonAlreadyRegisteredException();
        var person = personMapper.toEntity(personDto);
        person = personRepository.save(person);
        return new PersonResponse().withMessage("Person created successfully with id " + person.getId());
    }

    @Override
    @Transactional
    public void updatePerson(Long id, PersonDto personDto) {
        var person = personMapper.toEntity(personDto);
        personRepository.findById(id)
                .map(p -> {
                    p.setId(person.getId());
                    p.setFirstName(person.getFirstName());
                    p.setLastName(person.getLastName());
                    p.setCpf(person.getCpf());
                    p.setBirthDate(person.getBirthDate());
                    p.setPhones(person.getPhones());
                    return personRepository.save(p);
                })
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Person person = findPerson(id);
        personRepository.delete(person);
    }

    private Person findPerson(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

}
