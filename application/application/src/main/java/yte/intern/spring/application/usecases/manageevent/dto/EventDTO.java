package yte.intern.spring.application.usecases.manageevent.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EventDTO {

    private String eventName;

    private double longitude;

    private double latitude;

    private LocalDate eventStartDate;

    private LocalDate eventEndDate;

    private long quota;
}
