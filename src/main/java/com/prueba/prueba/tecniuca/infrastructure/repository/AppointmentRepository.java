package com.prueba.prueba.tecniuca.infrastructure.repository;

import com.prueba.prueba.tecniuca.domain.entity.Appointment;
import com.prueba.prueba.tecniuca.domain.entity.Doctor;
import com.prueba.prueba.tecniuca.domain.ports.out.AppointmentInterfacePortOut;
import com.prueba.prueba.tecniuca.infrastructure.entity.AppointmentEntity;
import com.prueba.prueba.tecniuca.infrastructure.mapper.AppointmentMapperInfra;
import com.prueba.prueba.tecniuca.infrastructure.mapper.AppointmentMapperRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class AppointmentRepository implements AppointmentInterfacePortOut {

    private final AppointmentJpaRepository appointmentJpaRepository;

    @Autowired
    public AppointmentRepository(AppointmentJpaRepository appointmentJpaRepository) {
        this.appointmentJpaRepository = appointmentJpaRepository;
    }

    @Override
    public Appointment save(Appointment newAppointment) {
        return AppointmentMapperInfra.toDomain(
                appointmentJpaRepository.save(AppointmentMapperInfra.toEntity(newAppointment))
        );
    }

    @Override
    public Optional<Appointment> findById(long id) {
        return appointmentJpaRepository.findById(id)
                .map(AppointmentMapperInfra::toDomain);
    }


    @Override
    public void deleteAppointment(long appointmentId) {
        appointmentJpaRepository.deleteById(appointmentId);
    }

    public boolean existsByDoctorAndDateTime(Long doctorId, LocalDateTime dateTime) {
        return appointmentJpaRepository.existsByDoctorIdAndDateTime(doctorId, dateTime);
    }

    @Override
    public List<Appointment> getAppointmentPatient(long patientId) {
        return appointmentJpaRepository.findByPatientId(patientId)
                .stream()
                .map(AppointmentMapperInfra::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Appointment> getAppointmentDoctor(long doctorId) {
        return appointmentJpaRepository.findByDoctorId(doctorId)
                .stream()
                .map(AppointmentMapperInfra::toDomain)
                .collect(Collectors.toList());
    }


}



