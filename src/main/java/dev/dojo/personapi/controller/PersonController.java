package dev.dojo.personapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dojo.personapi.dto.request.PersonDto;
import dev.dojo.personapi.dto.response.PersonResponse;
import dev.dojo.personapi.models.Person;
import dev.dojo.personapi.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> findAllPersons() {
        return ResponseEntity.ok(personService.findAllPersons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personService.findPersonById(id));
    }

    @PostMapping
    public ResponseEntity<PersonResponse> savePerson(@RequestBody @Valid PersonDto personDto) {
        var p = personService.savePerson(personDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new PersonResponse().withMessage("Person created successfully with id " + p.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonResponse> updatePerson(@PathVariable("id") Long id,
            @RequestBody PersonDto personDto) {
        personService.updatePerson(id, personDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
