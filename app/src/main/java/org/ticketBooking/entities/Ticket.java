package org.ticketBooking.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Ticket {
    @JsonProperty("ticket_id")
    private String ticketId;
    private String journey;
    private String seat;
}
