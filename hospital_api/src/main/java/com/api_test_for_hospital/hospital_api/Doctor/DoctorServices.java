package com.api_test_for_hospital.hospital_api.Doctor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Service
@SpringBootApplication
public class DoctorServices {
    private final DoctorRegistry doctorRegistry;

    @Autowired
    public DoctorServices(DoctorRegistry doctorRegistry) {
        this.doctorRegistry = doctorRegistry;
    }

    public List<Doctor> getDoctors() {
        // get all doctors
        return doctorRegistry.doctors;
    }

    public void addDoctor(Doctor doctor) {
        // add if info is right (try and catch before checks)
        doctorRegistry.doctors.add(doctor);
    }

    public void deleteDoctor(int id) {
        // remove if object exists (try and catch before checks)
        doctorRegistry.doctors.removeIf(d -> d.getDoctorId() == id);
    }

    public Optional<Doctor> getDoctorById(int id) {
        // find by id if exists
        Optional<Doctor> doctor = doctorRegistry.doctors.stream().filter(d -> d.getDoctorId() == id).findAny();
        return doctor;
    }

    public void changeName(int id, String name) {
        Optional<Doctor> optionalDoctor = doctorRegistry.doctors.stream().filter(d -> d.getDoctorId() == id).findAny();
        Doctor doctor = optionalDoctor.orElse(null);
        if (doctor != null) {
            doctor.setName(name);
        }
    }
}