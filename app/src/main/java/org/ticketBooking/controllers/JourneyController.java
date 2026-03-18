package org.ticketBooking.controllers;

import org.ticketBooking.services.JourneyService;
import org.ticketBooking.utils.InputUtil;

public class JourneyController {
    private final JourneyService journeyService;

    public JourneyController(JourneyService journeyService){
        this.journeyService = journeyService;
    }

    public void listJourneys() {

    }
}
