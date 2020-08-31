package yte.intern.spring.application.usecases.manageperson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.spring.application.usecases.manageperson.entity.Person;

import javax.transaction.Transactional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByTcKimlikNo(String tcKimlikNo);

    @Transactional
    void deleteByTcKimlikNo(String tcKimlikNo);
}
