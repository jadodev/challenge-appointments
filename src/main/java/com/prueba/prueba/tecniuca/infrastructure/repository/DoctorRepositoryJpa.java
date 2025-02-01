package com.prueba.prueba.tecniuca.infrastructure.repository;

import com.prueba.prueba.tecniuca.infrastructure.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepositoryJpa extends JpaRepository<DoctorEntity, Long> { }
