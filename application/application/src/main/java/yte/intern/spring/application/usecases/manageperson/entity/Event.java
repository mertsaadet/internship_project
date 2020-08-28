package yte.intern.spring.application.usecases.manageperson.entity;


import lombok.Getter;
import lombok.Setter;
import yte.intern.spring.application.usecases.common.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "idgen", sequenceName = "EVENT_SEQ")
public class Event extends BaseEntity {


    @Column(name = "EVENTDATE")
    private LocalDate eventDate;

    @Column(name = "QUOTA")
    private Long quota;

}
