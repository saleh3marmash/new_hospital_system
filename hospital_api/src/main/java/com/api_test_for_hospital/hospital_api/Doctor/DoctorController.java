package com.api_test_for_hospital.hospital_api.Doctor;

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
public class DoctorController {
    private final DoctorServices doctorServices;

    @Autowired
    public DoctorController(DoctorServices doctorServices) {
        this.doctorServices = doctorServices;
    }

    // get all doctors
    @GetMapping("api/getDoctors")
    public List<Doctor> getDoctors() {
        return doctorServices.getDoctors();
    }

    // adding a doctor
    @PostMapping("api/addDoctor")
    public String addDoctor(@RequestBody Doctor doctor) {
        try {
            doctorServices.addDoctor(doctor);
            return ("Added Doctor Successfully");
        } catch (Exception e) {
            return "There was an error adding that doctor";
        }
    }

    // deleting a doctor
    @DeleteMapping("api/deleteDoctor/{id}")
    public String deleteDoctor(@PathVariable("id") int id) {
        try {
            doctorServices.deleteDoctor(id);
            return "Doctor deleted successfully";
        } catch (Exception e) {
            return "There was an error deleting that doctor";
        }
    }

    // get a specific doctor by id
    @GetMapping("api/getDoctor/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable("id") int id) {
        return doctorServices.getDoctorById(id);
    }

    // changing the name of a doctor
    @PutMapping("api/changeDoctorName/{id}/{name}")
    public String changeName(@PathVariable("id") int id, @PathVariable("name") String name) {
        try {
            doctorServices.changeName(id, name);
            return ("Name changed Successfully");
        } catch (Exception e) {
            return ("There's no such ID");
        }
    }
}