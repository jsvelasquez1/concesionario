package com.espe.concesionario.repositories;

import com.espe.concesionario.models.VehiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepo extends JpaRepository<VehiculoModel, Long> {

}
