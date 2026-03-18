package org.ticketBooking.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Booking {
    @JsonProperty("booking_id")
    private String bookingId;
    private String user;
    private String ticket;
    @JsonProperty("is_active")
    private boolean isActive;
}
