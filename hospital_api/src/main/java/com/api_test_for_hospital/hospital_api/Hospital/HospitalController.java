package com.api_test_for_hospital.hospital_api.Hospital;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@SpringBootApplication
public class HospitalController {
    private final HospitalServices hospitalServices;

    @Autowired
    public HospitalController(HospitalServices hospitalServices) {
        this.hospitalServices = hospitalServices;
    }

    @GetMapping("api/getHospitals")
    public List<Hospital> getHospitals() {
        return hospitalServices.getHospitals();
    }

    @PostMapping("api/addHospital")
    public String addHospital(@RequestBody Hospital hospital) {
        try {
            hospitalServices.addHospital(hospital);
            return "Added Hospital Successfully";
        } catch (Exception e) {
            return "There was an error adding the hospital";
        }
    }

    @DeleteMapping("api/deleteHospital/{id}")
    public String deleteHospital(@PathVariable("id") int id) {
        try {
            hospitalServices.deleteHospital(id);
            return "Hospital deleted successfully";
        } catch (Exception e) {
            return "There was an error deleting the hospital";
        }
    }

    @GetMapping("api/getHospital/{id}")
    public Optional<Hospital> getHospitalById(@PathVariable("id") int id) {
        return hospitalServices.getHospitalById(id);
    }

    @PutMapping("api/changeHospitalName/{id}/{name}")
    public String changeHospitalName(@PathVariable("id") int id, @PathVariable("name") String name) {
        try {
            hospitalServices.changeHospitalName(id, name);
            return "Hospital updated successfully";
        } catch (Exception e) {
            return "There was an error updating the hospital";
        }
    }
}
