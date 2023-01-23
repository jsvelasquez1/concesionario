package com.espe.concesionario.controllers;

import com.espe.concesionario.models.EmpleadoModel;
import com.espe.concesionario.repositories.EmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/empleado")

public class EmpleadoController {
    @Autowired
    EmpleadoRepo empleadoRepo;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmpleadoModel> listarEmpleados(){
        return empleadoRepo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public EmpleadoModel crearEmpleado(@RequestBody EmpleadoModel empleadoModel){
        return empleadoRepo.save(empleadoModel);
    }


    @GetMapping(path = "/{id}")
    public Optional<EmpleadoModel> empleadoPorId(@PathVariable(value = "id") Long empleadoId) {
        return empleadoRepo.findById(empleadoId);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmpleadoModel actualizarEmpleado(@RequestBody EmpleadoModel empleadoBody, @PathVariable Long id){
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

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarEmpleado(@PathVariable Long id){
        empleadoRepo.deleteById(id);
    }
}
