package com.example.Hackathon.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ApplicantNameDTO implements ApplicantDataDTO{
    private String applicantFirstName;
    private String applicantMiddleName;
    private String applicantLastName;
}
