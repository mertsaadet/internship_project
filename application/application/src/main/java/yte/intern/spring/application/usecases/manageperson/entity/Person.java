package yte.intern.spring.application.usecases.manageperson.entity;


import lombok.Getter;
import lombok.Setter;
import yte.intern.spring.application.usecases.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "idgen", sequenceName = "PERSON_SEQ")
public class Person extends BaseEntity {


    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "TC_KIMLIK_NO", unique = true)
    private String tcKimlikNo;

    @Column(name = "EMAIL", unique = true)
    private String email;


}
