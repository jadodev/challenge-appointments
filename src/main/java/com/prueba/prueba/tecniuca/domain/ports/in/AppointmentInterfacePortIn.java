package com.prueba.prueba.tecniuca.domain.ports.in;

import com.prueba.prueba.tecniuca.domain.entity.Appointment;
import com.prueba.prueba.tecniuca.domain.entity.Doctor;
import com.prueba.prueba.tecniuca.domain.entity.Patient;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentInterfacePortIn {
    Appointment createAppointment(Doctor doctor, Patient patient, LocalDateTime dateTime);
    void deleteAppointment(long appointmentId);
    List<Appointment> getAppointmentPatient(long patientId);
    List<Appointment> getAppointmentDoctor(long doctorId);
}
