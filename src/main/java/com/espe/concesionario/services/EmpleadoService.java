package com.espe.concesionario.services;

import com.espe.concesionario.models.EmpleadoModel;
import com.espe.concesionario.repositories.EmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepo empleadoRepo;


    public List<EmpleadoModel> listarEmpleados(){
        return empleadoRepo.findAll();
    }

    public EmpleadoModel crearEmpleado(EmpleadoModel empleadoModel){
        return empleadoRepo.save(empleadoModel);
    }

    public Optional<EmpleadoModel> empleadoPorId(Long empleadoId) {
        return empleadoRepo.findById(empleadoId);
    }

    public EmpleadoModel actualizarEmpleado(EmpleadoModel empleadoBody, Long id){
        Optional<EmpleadoModel> existingClient = empleadoRepo.findById(id);
        EmpleadoModel empleadoActualizado = existingClient.get();
        if(existingClient!=null){
            empleadoActualizado.setNombre(empleadoBody.getNombre());
            empleadoActualizado.setApellido(empleadoBody.getApellido());
            empleadoActualizado.setCargo(empleadoBody.getCargo());
            empleadoActualizado.setFecha_contrato(empleadoBody.getFecha_contrato());
            empleadoActualizado.setSalario(empleadoBody.getSalario());
        }
        return empleadoRepo.save(empleadoActualizado);
    }

    public void eliminarEmpleado(Long id){
        empleadoRepo.deleteById(id);
    }
}
