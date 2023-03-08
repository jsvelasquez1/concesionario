package com.espe.concesionario.services;

import com.espe.concesionario.models.VehiculoModel;
import com.espe.concesionario.repositories.VehiculoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {
    @Autowired
    VehiculoRepo vehiculoRepo;

    public List<VehiculoModel> listarVehiculos(){
        return vehiculoRepo.findAll();
    }

    public VehiculoModel crearVehiculo(VehiculoModel vehiculoModel){
        return vehiculoRepo.save(vehiculoModel);
    }

    public Optional<VehiculoModel> vehiculoPorId(Long vehiculoId) {
        return vehiculoRepo.findById(vehiculoId);
    }

    public VehiculoModel actualizarVehiculo(VehiculoModel vehiculoBody, Long id){
        Optional<VehiculoModel> existingVehiculo = vehiculoRepo.findById(id);
        VehiculoModel vehiculoActualizado = existingVehiculo.get();
        if(existingVehiculo!=null){
            vehiculoActualizado.setColor(vehiculoBody.getColor());
            vehiculoActualizado.setMarca(vehiculoBody.getMarca());
            vehiculoActualizado.setPrecio(vehiculoBody.getPrecio());
            vehiculoActualizado.setModelo(vehiculoBody.getModelo());
            vehiculoActualizado.setMatricula(vehiculoBody.getMatricula());
        }
        return vehiculoRepo.save(vehiculoActualizado);
    }

    public void eliminarVehiculo(Long id){
        vehiculoRepo.deleteById(id);
    }
}
