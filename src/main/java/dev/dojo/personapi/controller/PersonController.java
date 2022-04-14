package dev.dojo.personapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dojo.personapi.dto.PersonResponse;
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

    @GetMapping("/:id")
    public ResponseEntity<Person> findPersonById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findPersonById(id));
    }

    @PostMapping
    public ResponseEntity<PersonResponse> savePerson(Person person) {
        personService.savePerson(person);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new PersonResponse().withMessage("Person created successfully!"));
    }

    @PutMapping
    public ResponseEntity<PersonResponse> updatePerson(Person person) {
        personService.updatePerson(person);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
