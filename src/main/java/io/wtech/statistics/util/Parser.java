package io.wtech.statistics.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.wtech.statistics.model.Employee;

import java.net.URI;
import java.util.List;

public class Parser {
    private final ObjectMapper mapper;

    public Parser(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public <T> T parse(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public List<Employee> parse(String testDataUrl) {
        try {
            return mapper.readValue(new URI(testDataUrl).toURL(), new TypeReference<>() {});
        } catch (Exception e) {
            return null;
        }
    }
}
