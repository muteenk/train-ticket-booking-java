package org.ticketBooking.entities;

import java.util.Map;
import java.util.Optional;

public class Train {
    private String trainId;
    private String trainNo;
    private String trainName;
    private Map<Integer, Optional<String>> seats;
}
