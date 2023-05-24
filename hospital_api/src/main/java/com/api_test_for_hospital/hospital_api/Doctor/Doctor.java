package com.api_test_for_hospital.hospital_api.Doctor;
import com.api_test_for_hospital.hospital_api.Person.Person;
public class Doctor extends Person {
    private int doctorId;
    private String speciality;
    private String certification;
    private int workingHours;

    public Doctor(int id, String name, boolean gender, String phoneNumber, String birthDate, String address,int doctorId, String speciality, String certification, int workingHours) {
        super(id,name,gender,phoneNumber,birthDate,address);
        this.doctorId = doctorId;
        this.speciality = speciality;
        this.certification = certification;
        this.workingHours = workingHours;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }
}
