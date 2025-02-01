package com.prueba.prueba.tecniuca.infrastructure.mapper;

import com.prueba.prueba.tecniuca.domain.entity.Appointment;
import com.prueba.prueba.tecniuca.domain.entity.Doctor;
import com.prueba.prueba.tecniuca.domain.entity.Patient;
import com.prueba.prueba.tecniuca.infrastructure.entity.AppointmentEntity;

public class AppointmentMapperInfra {

    public static AppointmentEntity toEntity(Appointment appointment) {
        return new AppointmentEntity(
                appointment.getId(),
                appointment.getDoctor().getId(),
                appointment.getDoctor().getName(),
                appointment.getDoctor().getSpeciality(),
                appointment.getPatient().getId(),
                appointment.getPatient().getName(),
                appointment.getDate()
        );
    }

    public static Appointment toDomain(AppointmentEntity entity) {
        return new Appointment(
                entity.getId(),
                new Doctor(entity.getDoctorId(), entity.getDoctorName(), entity.getDoctorSpeciality()),
                new Patient(entity.getPatientId(), entity.getPatientName()),
                entity.getDateTime()
        );
    }
}