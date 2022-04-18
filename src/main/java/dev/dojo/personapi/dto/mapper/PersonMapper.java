package dev.dojo.personapi.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dev.dojo.personapi.dto.request.PersonDto;
import dev.dojo.personapi.models.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toEntity(PersonDto dto);

    PersonDto toDTO(Person dto);
}
