package yte.intern.spring.application.usecases.manageperson.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.spring.application.usecases.manageperson.entity.Person;
import yte.intern.spring.application.usecases.manageperson.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagePersonService {

    private final PersonRepository personRepository;

    public void addPerson(Person person){
        //Add person to repository
        personRepository.save(person);
    }

    public void deletePersonByTcKimlikNo(String tcKimlikNo) {
        //Delete person from repository
        personRepository.deletePersonByTcKimlikNo(tcKimlikNo);
    }



    public List<Person> listAllPeople() {
        return personRepository.findAll();
    }

    public Person getPersonByTcKimlikNo(String tcKimlikNo) {
        return personRepository.findByTcKimlikNo(tcKimlikNo);
    }
}
