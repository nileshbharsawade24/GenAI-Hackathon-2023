package com.example.Hackathon.controller;

import com.example.Hackathon.dto.ApplicantAddressDTO;
import com.example.Hackathon.dto.ApplicantNameDTO;
import com.example.Hackathon.service.GenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api")
public class GenAIController {
    @Autowired
    private GenAIService genAIService;


    @PostMapping("/validateName")
    public Mono<?> validateApplicantName(@RequestBody Mono<ApplicantNameDTO> request) {

        return request.flatMap(dto -> {
            try {
                return genAIService.validateApplicantData(dto);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }


    @PostMapping("/validateAddress")
    public Mono<?> validateApplicantAddress(@RequestBody Mono<ApplicantAddressDTO> request) {
        return request.flatMap(dto -> {
            try {
                return genAIService.validateApplicantData(dto);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("up");
    }
}
