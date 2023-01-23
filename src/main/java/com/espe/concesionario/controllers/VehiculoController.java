package com.espe.concesionario.controllers;

import com.espe.concesionario.models.ClienteModel;
import com.espe.concesionario.models.VehiculoModel;
import com.espe.concesionario.repositories.ClienteRepo;
import com.espe.concesionario.repositories.VehiculoRepo;
import com.espe.concesionario.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehiculo")
@CrossOrigin(origins = "http://localhost:4200")
public class VehiculoController {
    @Autowired
    VehiculoRepo vehiculoRepo;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VehiculoModel> listarVehiculos(){
        return vehiculoRepo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public VehiculoModel crearVehiculo(@RequestBody VehiculoModel vehiculoModel){
        return vehiculoRepo.save(vehiculoModel);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Optional<VehiculoModel> vehiculoPorId(@PathVariable(value = "id") Long vehiculoId) {
        return vehiculoRepo.findById(vehiculoId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VehiculoModel actualizarVehiculo(@RequestBody VehiculoModel vehiculoBody, @PathVariable Long id){
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

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarVehiculo(@PathVariable Long id){
        vehiculoRepo.deleteById(id);
    }



    /*@CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void eliminarAutomovil(@PathVariable long id){
        automovilService.eliminarAutomovil(id);
    }*/

}
