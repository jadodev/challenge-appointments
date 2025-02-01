package com.prueba.prueba.tecniuca.application.mapper;

import com.prueba.prueba.tecniuca.application.dto.AppointmentDto;
import com.prueba.prueba.tecniuca.domain.entity.Appointment;

public class AppointmentMapper {

    public static AppointmentDto toDto(Appointment appointment) {
        return new AppointmentDto(
                appointment.getId(),
                appointment.getDoctor().getName(),
                appointment.getDoctor().getSpeciality(),
                appointment.getPatient().getName(),
                appointment.getDate()
        );
    }
}
