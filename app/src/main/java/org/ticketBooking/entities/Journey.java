package org.ticketBooking.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Date;

@Getter
public class Journey {
    @JsonProperty("journey_id")
    private String JourneyId;
    private String source;
    private String destination;
    private Date departure;
    private Date arrival;
    private String train;
}
