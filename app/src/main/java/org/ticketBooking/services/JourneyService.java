package org.ticketBooking.services;

import org.ticketBooking.repository.JourneyRepository;

public class JourneyService {
    private final JourneyRepository journeyRepository;

    public JourneyService(JourneyRepository journeyRepository){
        this.journeyRepository = journeyRepository;
    }
}
