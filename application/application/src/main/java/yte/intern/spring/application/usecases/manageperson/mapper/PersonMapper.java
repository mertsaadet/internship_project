package yte.intern.spring.application.usecases.manageperson.mapper;

import org.mapstruct.Mapper;
import yte.intern.spring.application.usecases.manageperson.dto.PersonDTO;
import yte.intern.spring.application.usecases.manageperson.entity.Person;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person mapToEntity(PersonDTO personDTO);

    PersonDTO mapToDto(Person person);

    List<Person> mapToEntity(List<PersonDTO> personDTOList);

    List<PersonDTO> mapToDto(List<Person> personList);
}
