package com.api_test_for_hospital.hospital_api.Patient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@Repository
@SpringBootApplication
public class PatientRegistry {
    List<Patient> patients = new ArrayList<>();

    public PatientRegistry() {
    }
}