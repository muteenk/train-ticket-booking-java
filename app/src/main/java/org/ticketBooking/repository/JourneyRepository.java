package org.ticketBooking.repository;

import org.ticketBooking.entities.Journey;
import org.ticketBooking.services.JsonService;

public class JourneyRepository {
    private final JsonService<Journey> journeyJsonService;

    public JourneyRepository(JsonService<Journey> journeyJsonService){
        this.journeyJsonService = journeyJsonService;
    }


}
