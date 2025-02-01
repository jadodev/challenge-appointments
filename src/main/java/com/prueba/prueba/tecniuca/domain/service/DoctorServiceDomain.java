package com.prueba.prueba.tecniuca.domain.service;

import com.prueba.prueba.tecniuca.domain.entity.Doctor;
import com.prueba.prueba.tecniuca.infrastructure.repository.DoctorRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceDomain {
    private final DoctorRepositoryJpa doctorRepository;

    public DoctorServiceDomain(DoctorRepositoryJpa doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(DoctorMapperRepository::toDomain)
                .collect(Collectors.toList());
    }

    public Doctor findDoctorById(long id) {
        return doctorRepository.findById(id)
                .map(DoctorMapperRepository::toDomain)
                .orElse(null);
    }
}
