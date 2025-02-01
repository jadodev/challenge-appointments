package com.prueba.prueba.tecniuca.infrastructure.repository;

import com.prueba.prueba.tecniuca.infrastructure.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentJpaRepository extends JpaRepository<AppointmentEntity, Long> {
        boolean existsByDoctorIdAndDateTime(Long doctorId, LocalDateTime dateTime);
        List<AppointmentEntity> findByPatientId(Long patientId);
        List<AppointmentEntity> findByDoctorId(Long doctorId);
}