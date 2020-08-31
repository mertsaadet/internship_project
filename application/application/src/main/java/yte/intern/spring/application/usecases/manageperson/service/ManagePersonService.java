package yte.intern.spring.application.usecases.manageperson.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.spring.application.usecases.common.MessageResponse;
import yte.intern.spring.application.usecases.common.enums.MessageType;
import yte.intern.spring.application.usecases.manageperson.entity.Person;
import yte.intern.spring.application.usecases.manageperson.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagePersonService {

    private final PersonRepository personRepository;

    public MessageResponse addPerson(Person person){
        //Add person to repository
        personRepository.save(person);
        return new MessageResponse("Succesfully added person!", MessageType.SUCCESS);
    }


    public List<Person> listAllPeople() {
        return personRepository.findAll();
    }

    public Person getPersonByTcKimlikNo(String tcKimlikNo) {
        return personRepository.findByTcKimlikNo(tcKimlikNo);
    }

    public MessageResponse updatePerson(String tcKimlikNo, Person person) {
        Person personFromDB= personRepository.findByTcKimlikNo(tcKimlikNo);
        if(personFromDB != null){
            updatePersonFields(person, personFromDB);

            personRepository.save(personFromDB);
            return new MessageResponse(String.format("Successfully updated person with tc:%s",tcKimlikNo),MessageType.SUCCESS);
        }
        return new MessageResponse(String.format("Can't find person with tc:%s",tcKimlikNo),MessageType.ERROR);
    }

    private void updatePersonFields(Person person, Person personFromDB) {
        personFromDB.setName(person.getName());
        personFromDB.setSurname(person.getSurname());
        personFromDB.setEmail(person.getEmail());
        personFromDB.setTcKimlikNo(person.getTcKimlikNo());
    }

    public MessageResponse deletePerson(String tcKimlikNo) {
        personRepository.deleteByTcKimlikNo(tcKimlikNo);
        return new MessageResponse(String.format("Deleted person with tc:%s",tcKimlikNo),MessageType.SUCCESS);

    }
}
