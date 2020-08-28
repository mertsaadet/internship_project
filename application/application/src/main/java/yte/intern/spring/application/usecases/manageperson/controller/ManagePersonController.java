package yte.intern.spring.application.usecases.manageperson.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.spring.application.usecases.manageperson.dto.PersonDTO;
import yte.intern.spring.application.usecases.manageperson.entity.Person;
import yte.intern.spring.application.usecases.manageperson.mapper.PersonMapper;
import yte.intern.spring.application.usecases.manageperson.service.ManagePersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManagePersonController {

    private final PersonMapper personMapper;
    private final ManagePersonService managePersonService;

    @PostMapping("/people")
    public void addPerson(@RequestBody PersonDTO personDTO){
        Person person = personMapper.mapToEntity(personDTO);
        managePersonService.addPerson(person);
    }
    @GetMapping("/people")
    public List<PersonDTO> listAllPeople(){
        List<Person> people = managePersonService.listAllPeople();

        return personMapper.mapToDto(people);
    }
    @GetMapping("/people/{tcKimlikNo}")
    public PersonDTO getPersonByTcKimlikNo(@PathVariable String tcKimlikNo){

        Person person = managePersonService.getPersonByTcKimlikNo(tcKimlikNo);
        return personMapper.mapToDto(person);
    }


    @DeleteMapping("/people/{tcKimlikNo}")
    public void deletePersonByTcKimlikNo(@PathVariable String tcKimlikNo){
        managePersonService.deletePersonByTcKimlikNo(tcKimlikNo);
    }

}
