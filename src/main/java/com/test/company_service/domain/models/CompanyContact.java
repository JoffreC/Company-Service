package com.test.company_service.domain.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

// Domain model for information of the external service Contact-Service
@Data
public class CompanyContact {
    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickname;
    private LocalDate birthday;
    private String gender;
    private Boolean isActive;
}
