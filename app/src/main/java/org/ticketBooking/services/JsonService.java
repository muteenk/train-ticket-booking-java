package org.ticketBooking.services;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonService<T> {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final Class<T> type;
    private final InputStream file;
    // private String filePath;

    public JsonService(String filePath, Class<T> type) {
        this.file = getClass()
                .getClassLoader()
                .getResourceAsStream("datastore/users.json");;
        this.type = type;
        // this.filePath = filePath;
    }

    public List<T> getData() throws IOException {
        JavaType listType = OBJECT_MAPPER
                .getTypeFactory()
                .constructCollectionType(List.class, this.type);
        return OBJECT_MAPPER.readValue(
                this.file,
                listType
        );
    }
}
