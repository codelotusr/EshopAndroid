package com.coursework.eshop.model;

import java.time.LocalDate;
import java.util.List;


public class Manager extends User {
    private String employeeId;
    private String medicalCertification;
    private LocalDate employmentDate;
    public Manager(String username, String password, LocalDate birthDate, String firstName, String lastName, String employeeId, String medicalCertification, LocalDate employmentDate, String role) {
        super(username, password, birthDate, firstName, lastName, role);
        this.employeeId = employeeId;
        this.medicalCertification = medicalCertification;
        this.employmentDate = employmentDate;
    }

}
