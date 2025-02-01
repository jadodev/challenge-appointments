package com.prueba.prueba.tecniuca.domain.service;

import com.prueba.prueba.tecniuca.domain.entity.Appointment;
import com.prueba.prueba.tecniuca.domain.entity.Doctor;
import com.prueba.prueba.tecniuca.domain.entity.Patient;
import com.prueba.prueba.tecniuca.domain.ports.in.AppointmentInterfacePortIn;
import com.prueba.prueba.tecniuca.domain.ports.out.AppointmentInterfacePortOut;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentsServiceDomain implements AppointmentInterfacePortIn {
    private final AppointmentInterfacePortOut appointmentRepository;

    public AppointmentsServiceDomain(AppointmentInterfacePortOut appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment createAppointment(Doctor doctor, Patient patient, LocalDateTime dateTime) {
        if (appointmentRepository.existsByDoctorAndDateTime(doctor, dateTime)) {
            throw new IllegalArgumentException("El doctor no está disponible en este horario.");
        }
        Appointment newAppointment = new Appointment(null, doctor, patient, dateTime);
        return appointmentRepository.save(newAppointment);
    }

    @Override
    public void deleteAppointment(long appointmentId) {
        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
        appointment.ifPresent(a -> appointmentRepository.deleteAppointment(appointmentId));
    }

    @Override
    public List<Appointment> getAppointmentPatient(long patientId) {
        return appointmentRepository.getAppointmentPatient(patientId);
    }

    @Override
    public List<Appointment> getAppointmentDoctor(long doctorId) {
        return appointmentRepository.getAppointmentDoctor(doctorId);
    }
}

