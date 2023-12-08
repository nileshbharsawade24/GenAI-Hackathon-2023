package com.example.Hackathon.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class JacksonJsonUtil {

    @Autowired
    private ObjectMapper mapper;

    private static final String OBJECT_TO_JSON_CONVERSION_ERROR = "Failed to get json from object";


}
