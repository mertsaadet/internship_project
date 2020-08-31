package yte.intern.spring.application.usecases.manageperson.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.spring.application.usecases.common.MessageResponse;
import yte.intern.spring.application.usecases.manageperson.dto.PersonDTO;
import yte.intern.spring.application.usecases.manageperson.entity.Person;
import yte.intern.spring.application.usecases.manageperson.mapper.PersonMapper;
import yte.intern.spring.application.usecases.manageperson.service.ManagePersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class ManagePersonController {

    private final PersonMapper personMapper;
    private final ManagePersonService managePersonService;

    @PostMapping
    public MessageResponse addPerson(@RequestBody PersonDTO personDTO){
        Person person = personMapper.mapToEntity(personDTO);
        return managePersonService.addPerson(person);
    }
    @GetMapping
    public List<PersonDTO> listAllPeople(){
        List<Person> people = managePersonService.listAllPeople();

        return personMapper.mapToDto(people);
    }
    @GetMapping("/{tcKimlikNo}")
    public PersonDTO getPersonByTcKimlikNo(@PathVariable String tcKimlikNo){

        Person person = managePersonService.getPersonByTcKimlikNo(tcKimlikNo);
        return personMapper.mapToDto(person);
    }

    @PutMapping("/{tcKimlikNo}")
    public MessageResponse updatePerson(@PathVariable String tcKimlikNo, @RequestBody PersonDTO personDTO){
        Person person = personMapper.mapToEntity(personDTO);
        return managePersonService.updatePerson(tcKimlikNo, person);
    }

    @DeleteMapping("/{tcKimlikNo}")
    public MessageResponse deletePersonByTcKimlikNo(@PathVariable String tcKimlikNo){
        return managePersonService.deletePerson(tcKimlikNo);
    }

}
