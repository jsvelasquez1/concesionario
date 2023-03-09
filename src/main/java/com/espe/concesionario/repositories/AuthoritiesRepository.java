package com.espe.concesionario.repositories;

import com.espe.concesionario.models.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthoritiesRepository  extends JpaRepository<Authorities, Integer>{
    Optional<Authorities> findByAuthority(String Authority);
}