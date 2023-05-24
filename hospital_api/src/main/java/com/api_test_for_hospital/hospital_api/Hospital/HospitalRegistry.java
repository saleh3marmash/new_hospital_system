package com.api_test_for_hospital.hospital_api.Hospital;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@Repository
@SpringBootApplication
public class HospitalRegistry {
    List<Hospital> hospitals = new ArrayList<>();

    public HospitalRegistry() {
    }
}