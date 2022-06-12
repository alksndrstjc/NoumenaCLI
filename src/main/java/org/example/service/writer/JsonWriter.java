package org.example.service.writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Model;

import java.io.IOException;
import java.util.List;

public class JsonWriter implements Writer {
    private final ObjectMapper mapper;

    public JsonWriter() {
        this.mapper = new ObjectMapper();
    }

    public void write(List<Model> models) {
        try {
            mapper.writer().writeValue(System.out, models);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
