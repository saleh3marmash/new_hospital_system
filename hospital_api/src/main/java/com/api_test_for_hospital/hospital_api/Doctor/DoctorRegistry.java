package com.api_test_for_hospital.hospital_api.Doctor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@Repository
@SpringBootApplication
public class DoctorRegistry {
    // note: registry/repository is supposed to have a database, but I haven't implemented it yet.
    // just initializing
    List<Doctor> doctors = new ArrayList<>();

    public DoctorRegistry() {
    }
}
