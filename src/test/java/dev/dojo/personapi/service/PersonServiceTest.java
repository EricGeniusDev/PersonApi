package dev.dojo.personapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.dojo.personapi.dto.mapper.PersonMapper;
import dev.dojo.personapi.dto.request.PersonDto;
import dev.dojo.personapi.dto.response.PersonResponse;
import dev.dojo.personapi.models.Person;
import dev.dojo.personapi.repository.PersonRepository;
import dev.dojo.personapi.service.impl.PersonServiceImpl;
import dev.dojo.personapi.utils.PersonUtils;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PersonDto personDTO = PersonUtils.createFakeDTO();
        Person expectedSavedPerson = PersonUtils.createFakeEntity();

        when(personMapper.toEntity(personDTO)).thenReturn(expectedSavedPerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        PersonResponse expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
        PersonResponse successMessage = personService.savePerson(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private PersonResponse createExpectedSuccessMessage(Long savedPersonId) {
        return PersonResponse.builder()
                .message("Person created successfully with id " + savedPersonId)
                .build();
    }
}