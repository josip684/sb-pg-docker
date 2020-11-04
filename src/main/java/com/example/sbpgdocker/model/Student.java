package com.example.sbpgdocker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

public class Student {

    private final UUID id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private Date dateOfBirth;

    @NotBlank
    private String identificationCodeNumber;

    public Student(@JsonProperty("id") UUID id,
                   @JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("dateOfBirth") Date dateOfBirth,
                   @JsonProperty("identificationCodeNumber") String identificationCodeNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.identificationCodeNumber = identificationCodeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdentificationCodeNumber() {
        return identificationCodeNumber;
    }

    public void setIdentificationCodeNumber(String identificationCodeNumber) {
        this.identificationCodeNumber = identificationCodeNumber;
    }
}
