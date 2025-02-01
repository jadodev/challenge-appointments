package com.prueba.prueba.tecniuca.infrastructure.controller;

import com.prueba.prueba.tecniuca.application.dto.AppointmentDto;
import com.prueba.prueba.tecniuca.application.service.AppointmentApplicationService;
import com.prueba.prueba.tecniuca.application.service.AppointmentRequest;
import com.prueba.prueba.tecniuca.domain.entity.Doctor;
import com.prueba.prueba.tecniuca.domain.entity.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentsController {
    private final AppointmentApplicationService appointmentApplicationService;

    public AppointmentsController(AppointmentApplicationService appointmentApplicationService) {
        this.appointmentApplicationService = appointmentApplicationService;
    }

    @PostMapping("/create")
    public ResponseEntity<AppointmentDto> create(@RequestBody AppointmentRequest request) {
        Doctor doctor = new Doctor( request.getDoctorId(), request.getDoctorName(),request.getDoctorSpeciality());
        Patient patient = new Patient( request.getPatientId(),request.getPatientName());

        AppointmentDto appointmentDto = appointmentApplicationService.createAppointment(doctor,patient, request.getDateTime());
        return ResponseEntity.ok(appointmentDto);
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByPatient(@PathVariable("id") long patientId) {
        List<AppointmentDto> appointments = appointmentApplicationService.getAppointmentsByPatient(patientId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByDoctor(@PathVariable("id") long doctorId) {
        List<AppointmentDto> appointments = appointmentApplicationService.getAppointmentsByDoctor(doctorId);
        return ResponseEntity.ok(appointments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelAppointment(@PathVariable("id") long id) {
        appointmentApplicationService.cancelAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
