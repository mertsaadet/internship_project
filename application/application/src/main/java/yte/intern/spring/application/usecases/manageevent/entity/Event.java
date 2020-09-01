package yte.intern.spring.application.usecases.manageevent.entity;


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

    @Column(name = "EVENTNAME", unique = true)
    private String eventName;

    @Column(name = "LONGITUDE")
    private double longitude;

    @Column(name = "LATITUDE")
    private double latitude;

    @Column(name = "EVENTSTARTDATE")
    private LocalDate eventStartDate;

    @Column(name = "EVENTENDDATE")
    private LocalDate eventEndDate;

    @Column(name = "QUOTA")
    private long quota;

}
