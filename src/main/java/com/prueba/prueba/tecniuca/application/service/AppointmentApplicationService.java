package com.prueba.prueba.tecniuca.application.service;

import com.prueba.prueba.tecniuca.application.dto.AppointmentDto;
import com.prueba.prueba.tecniuca.application.mapper.AppointmentMapper;
import com.prueba.prueba.tecniuca.domain.entity.Appointment;
import com.prueba.prueba.tecniuca.domain.entity.Doctor;
import com.prueba.prueba.tecniuca.domain.entity.Patient;
import com.prueba.prueba.tecniuca.domain.ports.in.AppointmentInterfacePortIn;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentApplicationService {
    private final AppointmentInterfacePortIn appointmentService;

    public AppointmentApplicationService(AppointmentInterfacePortIn appointmentService) {
        this.appointmentService = appointmentService;
    }

    public AppointmentDto createAppointment(Doctor doctor, Patient patient, LocalDateTime dateTime) {
        Appointment appointment = appointmentService.createAppointment(doctor, patient, dateTime);
        return AppointmentMapper.toDto(appointment);
    }

    public void cancelAppointment(long appointmentId) {
         appointmentService.deleteAppointment(appointmentId);
    }

    public List<AppointmentDto> getAppointmentsByPatient(long patientId) {
        return appointmentService.getAppointmentPatient(patientId)
                .stream()
                .map(AppointmentMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<AppointmentDto> getAppointmentsByDoctor(long doctorId) {
        return appointmentService.getAppointmentDoctor(doctorId)
                .stream()
                .map(AppointmentMapper::toDto)
                .collect(Collectors.toList());
    }

}
