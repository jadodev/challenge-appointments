package com.prueba.prueba.tecniuca.domain.ports.out;

import com.prueba.prueba.tecniuca.domain.entity.Appointment;
import com.prueba.prueba.tecniuca.domain.entity.Doctor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentInterfacePortOut {
    Appointment save(Appointment newAppointment);
    Optional<Appointment> findById(long id);
    void deleteAppointment(long appointmentId);
    boolean existsByDoctorAndDateTime(Doctor doctor, LocalDateTime dateTime);
    List<Appointment> getAppointmentPatient(long patientId);
    List<Appointment> getAppointmentDoctor(long doctorId);
}