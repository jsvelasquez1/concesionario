package com.espe.concesionario.controllers;

import com.espe.concesionario.models.EmpleadoModel;
import com.espe.concesionario.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/empleado")

public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmpleadoModel> listarEmpleados(){
        return empleadoService.listarEmpleados();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public EmpleadoModel crearEmpleado(@RequestBody EmpleadoModel empleadoModel){
        return empleadoService.crearEmpleado(empleadoModel);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Optional<EmpleadoModel> empleadoPorId(@PathVariable(value = "id") Long empleadoId) {
        return empleadoService.empleadoPorId(empleadoId);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmpleadoModel actualizarEmpleado(@RequestBody EmpleadoModel empleadoBody, @PathVariable Long id){
        return empleadoService.actualizarEmpleado(empleadoBody, id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarEmpleado(@PathVariable Long id){
        empleadoService.eliminarEmpleado(id);
    }
}
