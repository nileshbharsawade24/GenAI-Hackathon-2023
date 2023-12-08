package com.example.Hackathon.service;

import com.example.Hackathon.dto.ApplicantDataDTO;
import com.example.Hackathon.dto.GenAIModelRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Map;

@Service
public class GenAIService {
    @Autowired
    private ObjectMapper mapper;

    @Value("${external.api.url}")
    private String externalApiUrl;
    public Mono<?>  validateApplicantData(ApplicantDataDTO applicantDataDTO) throws Exception{

        GenAIModelRequestDTO genAIModelRequest = GenAIModelRequestDTO.builder()
                .prompt(mapper.writeValueAsString(applicantDataDTO))  // Assuming prompt is a String
                .temperature(0.4)
                .maxTokens(200)
                .build();

        return WebClient.create()
                .post()
                .uri(externalApiUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(genAIModelRequest))
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(responseString->{
                    String cleanedResponse = responseString.replaceAll("^\"|\"$", "").replace("\\", "");

                    ObjectMapper objectMapper = new ObjectMapper();
                    try {
                        Map<String, Object> responseMap = objectMapper.readValue(cleanedResponse, Map.class);
                        return Mono.just(responseMap);
                    } catch (IOException e) {
                        return Mono.error(new Exception("Failed to parse JSON response"));
                    }
                });

    }


}
