package com.api_test_for_hospital.hospital_api.Hospital;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Service
@SpringBootApplication
public class HospitalServices {
    private final HospitalRegistry hospitalRegistry;

    @Autowired
    public HospitalServices(HospitalRegistry hospitalRegistry) {
        this.hospitalRegistry = hospitalRegistry;
    }

    public List<Hospital> getHospitals() {
        // get all hospitals
        return hospitalRegistry.hospitals;
    }

    public void addHospital(Hospital hospital) {
        // add if info is right (try and catch before checks)
        hospitalRegistry.hospitals.add(hospital);
    }

    public void deleteHospital(int id) {
        // remove if object exists (try and catch before checks)
        hospitalRegistry.hospitals.removeIf(h -> h.getId() == id);
    }

    public Optional<Hospital> getHospitalById(int id) {
        // find by id if exists
        Optional<Hospital> hospital = hospitalRegistry.hospitals.stream().filter(h -> h.getId() == id).findAny();
        return hospital;
    }

    public void changeHospitalName(int id, String name) {
        Optional<Hospital> optionalHospital = hospitalRegistry.hospitals.stream().filter(h -> h.getId() == id).findAny();
        Hospital hospital = optionalHospital.orElse(null);
        if (hospital != null) {
            hospital.setName(name);
        }
    }
}