package com.api_test_for_hospital.hospital_api.Patient;
import com.api_test_for_hospital.hospital_api.Person.Person;
public class Patient extends Person {
    private int patientId;
    private String sickness;
    private String prescription;
    private String allergies;
    private String specialReq;

    public Patient(int id, String name, boolean gender, String phoneNumber, String dateOfBirth, String address, int patientId, String sickness, String prescription, String allergies, String specialReq) {
        super(id, name, gender, phoneNumber, dateOfBirth, address);
        this.patientId = patientId;
        this.sickness = sickness;
        this.prescription = prescription;
        this.allergies = allergies;
        this.specialReq = specialReq;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getSpecialReq() {
        return specialReq;
    }

    public void setSpecialReq(String specialReq) {
        this.specialReq = specialReq;
    }
}