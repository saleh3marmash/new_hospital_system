package com.api_test_for_hospital.hospital_api.Patient;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@SpringBootApplication
public class PatientController {
    private final PatientServices patientServices;

    @Autowired
    public PatientController(PatientServices patientServices) {
        this.patientServices = patientServices;
    }

    // get all patients
    @GetMapping("api/getPatients")
    public List<Patient> getPatients() {
        return patientServices.getPatients();
    }

    // add a patient
    @PostMapping("api/addPatient")
    public String addPatient(@RequestBody Patient patient) {
        try {
            patientServices.addPatient(patient);
            return "Added Patient Successfully";
        } catch (Exception e) {
            return "There was an error adding that patient";
        }
    }

    // delete a patient
    @DeleteMapping("api/deletePatient/{id}")
    public String deletePatient(@PathVariable("id") int id) {
        try {
            patientServices.deletePatient(id);
            return "Patient deleted successfully";
        } catch (Exception e) {
            return "There was an error deleting that patient";
        }
    }

    // get a specific patient by id
    @GetMapping("api/getPatient/{id}")
    public Optional<Patient> getPatientById(@PathVariable("id") int id) {
        return patientServices.getPatientById(id);
    }

    // change the name of a patient
    @PutMapping("api/changePatientName/{id}/{name}")
    public String changeName(@PathVariable("id") int id, @PathVariable("name") String name) {
        try {
            patientServices.changePatientName(id, name);
            return "Name changed successfully";
        } catch (Exception e) {
            return "There's no such ID";
        }
    }
}