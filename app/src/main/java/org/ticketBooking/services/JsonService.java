package org.ticketBooking.services;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonService<T> {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final Class<T> type;
    private final File file;

    public JsonService(String filePath, Class<T> type) {
        this.file = new File(filePath);;
        this.type = type;
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

    public void saveData(List<T> entity) throws IOException {
        OBJECT_MAPPER.writeValue(this.file, entity);
    }
}
