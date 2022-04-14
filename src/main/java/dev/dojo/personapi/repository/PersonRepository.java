package dev.dojo.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.dojo.personapi.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
