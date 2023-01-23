package com.espe.concesionario.repositories;

import com.espe.concesionario.models.ProveedorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepo extends JpaRepository<ProveedorModel, Long> {
}
