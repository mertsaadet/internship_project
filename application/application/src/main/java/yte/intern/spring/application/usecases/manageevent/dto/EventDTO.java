package yte.intern.spring.application.usecases.manageevent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Builder
public class EventDTO {
    @JsonProperty("eventName")
    public String eventName;
    @JsonProperty("longitude")
    public double longitude;
    @JsonProperty("latitude")
    public double latitude;

    @JsonProperty("eventStartDate")
    @DateTimeFormat
    public LocalDate eventStartDate;
    @JsonProperty("eventEndDate")
    public LocalDate eventEndDate;
    @JsonProperty("quota")
    public long quota;

    public EventDTO( @JsonProperty("eventName")
                            String eventName,
                    @JsonProperty("longitude")
                            double longitude,
                    @JsonProperty("latitude")
                            double latitude,

                    @JsonProperty("eventStartDate")
                            LocalDate eventStartDate,
                    @JsonProperty("eventEndDate")
                            LocalDate eventEndDate,
                    @JsonProperty("quota")
                            long quota) {
        this.eventName = eventName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.quota = quota;
    }
}
