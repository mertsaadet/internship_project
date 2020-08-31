package yte.intern.spring.application.usecases.manageperson.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import yte.intern.spring.application.usecases.manageperson.dto.PersonDTO;
import yte.intern.spring.application.usecases.manageperson.entity.Person;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-30T22:36:43+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 14.0.2 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person mapToEntity(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        Person person = new Person();

        person.setName( personDTO.getName() );
        person.setSurname( personDTO.getSurname() );
        person.setTcKimlikNo( personDTO.getTcKimlikNo() );
        person.setEmail( personDTO.getEmail() );

        return person;
    }

    @Override
    public PersonDTO mapToDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setName( person.getName() );
        personDTO.setSurname( person.getSurname() );
        personDTO.setEmail( person.getEmail() );
        personDTO.setTcKimlikNo( person.getTcKimlikNo() );

        return personDTO;
    }

    @Override
    public List<Person> mapToEntity(List<PersonDTO> personDTOList) {
        if ( personDTOList == null ) {
            return null;
        }

        List<Person> list = new ArrayList<Person>( personDTOList.size() );
        for ( PersonDTO personDTO : personDTOList ) {
            list.add( mapToEntity( personDTO ) );
        }

        return list;
    }

    @Override
    public List<PersonDTO> mapToDto(List<Person> personList) {
        if ( personList == null ) {
            return null;
        }

        List<PersonDTO> list = new ArrayList<PersonDTO>( personList.size() );
        for ( Person person : personList ) {
            list.add( mapToDto( person ) );
        }

        return list;
    }
}
