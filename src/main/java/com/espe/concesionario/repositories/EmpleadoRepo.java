package com.espe.concesionario.repositories;

import com.espe.concesionario.models.EmpleadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepo extends JpaRepository<EmpleadoModel, Long> {
}
