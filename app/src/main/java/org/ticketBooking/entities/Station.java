package org.ticketBooking.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Station {
    @JsonProperty("station_id")
    private String stationId;
    @JsonProperty("station_name")
    private String stationName;
}
