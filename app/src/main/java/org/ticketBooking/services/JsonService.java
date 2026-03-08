package org.ticketBooking.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonService {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private String filePath;
    private File file;

    JsonService(String filePath) {
        this.file = new File(filePath);
        this.filePath = filePath;
    }


}
