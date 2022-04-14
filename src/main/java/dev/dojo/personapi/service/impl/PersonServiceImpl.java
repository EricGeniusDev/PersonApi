package dev.dojo.personapi.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.dojo.personapi.dto.request.PersonDto;
import dev.dojo.personapi.exceptions.PersonNotFoundException;
import dev.dojo.personapi.models.Person;
import dev.dojo.personapi.repository.PersonRepository;
import dev.dojo.personapi.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person findPersonById(Long id) {
        return findPerson(id);
    }

    @Override
    public Person savePerson(PersonDto personDto) {
        var person = modelMapper.map(personDto, Person.class);
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long id, PersonDto personDto) {
        var person = modelMapper.map(personDto, Person.class);
        return personRepository.findById(id)
                .map(p -> {
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
    public void delete(Long id) {
        var person = findPerson(id);
        personRepository.delete(person);
    }

    private Person findPerson(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

}
