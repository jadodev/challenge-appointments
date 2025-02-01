package com.prueba.prueba.tecniuca.application.dto;
import java.time.LocalDateTime;

public class AppointmentDto {
    private long id;
    private String doctorName;
    private String patientName;
    private String speciality;
    private LocalDateTime dateTime;

    public AppointmentDto(long id, String doctorName, String patientName, String speciality, LocalDateTime dateTime) {
        this.id = id;
        this.doctorName = doctorName;
        this.speciality = speciality;
        this.patientName = patientName;
        this.dateTime = dateTime;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
