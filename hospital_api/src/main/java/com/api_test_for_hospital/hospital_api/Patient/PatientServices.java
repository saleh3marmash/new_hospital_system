package com.api_test_for_hospital.hospital_api.Patient;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Service
@SpringBootApplication
public class PatientServices {
    private final PatientRegistry patientRegistry;

    @Autowired
    public PatientServices(PatientRegistry patientRegistry) {
        this.patientRegistry = patientRegistry;
    }

    public List<Patient> getPatients() {
        // get all patients
        return patientRegistry.patients;
    }

    public void addPatient(Patient patient) {
        // add if info is right (try and catch before checks)
        patientRegistry.patients.add(patient);
    }

    public void deletePatient(int id) {
        // remove if object exists (try and catch before checks)
        patientRegistry.patients.removeIf(p -> p.getId() == id);
    }

    public Optional<Patient> getPatientById(int id) {
        // find by id if exists
        Optional<Patient> patient = patientRegistry.patients.stream().filter(p -> p.getId() == id).findAny();
        return patient;
    }

    public void changePatientName(int id, String name) {
        Optional<Patient> optionalPatient = patientRegistry.patients.stream().filter(p -> p.getId() == id).findAny();
        Patient patient = optionalPatient.orElse(null);
        if (patient != null) {
            patient.setName(name);
        }
    }
}