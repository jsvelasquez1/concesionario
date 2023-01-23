package com.espe.concesionario.repositories;

import com.espe.concesionario.models.VentasModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasRepo extends JpaRepository<VentasModel, Long> {
}
