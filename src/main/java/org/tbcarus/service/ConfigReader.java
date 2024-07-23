package org.tbcarus.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class ConfigReader {

    public static <T> T readConfig(String fileName, Class<T> clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            return objectMapper.readValue(new File(fileName), clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}