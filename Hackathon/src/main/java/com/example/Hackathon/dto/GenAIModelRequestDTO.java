package com.example.Hackathon.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class GenAIModelRequestDTO {
    @JsonProperty("prompt")
    private String prompt;

    @JsonProperty("temperature")
    private double temperature;

    @JsonProperty("max_tokens")
    private int maxTokens;
}
