package com.espe.concesionario.controllers;

import com.espe.concesionario.models.ProveedorModel;
import com.espe.concesionario.repositories.ProveedorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedor")
@CrossOrigin(origins = "http://localhost:4200")
public class ProveedorController {
    @Autowired
    ProveedorRepo proveedorRepo;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProveedorModel> listarProveedors(){
        return proveedorRepo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ProveedorModel crearProveedor(@RequestBody ProveedorModel proveedorModel){
        return proveedorRepo.save(proveedorModel);
    }


    @GetMapping(path = "/{id}")
    public Optional<ProveedorModel> proveedorPorId(@PathVariable(value = "id") Long proveedorId) {
        return proveedorRepo.findById(proveedorId);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProveedorModel actualizarProveedor(@RequestBody ProveedorModel proveedorBody, @PathVariable Long id){
        Optional<ProveedorModel> existingClient = proveedorRepo.findById(id);
        ProveedorModel proveedorActualizado = existingClient.get();
        if(existingClient!=null){
            proveedorActualizado.setNombre(proveedorBody.getNombre());
            proveedorActualizado.setDireccion(proveedorBody.getDireccion());
            proveedorActualizado.setNum_telefono(proveedorBody.getNum_telefono());
            proveedorActualizado.setDireccion(proveedorBody.getDireccion());
            proveedorActualizado.setDireccion(proveedorBody.getDireccion());
        }
        return proveedorRepo.save(proveedorActualizado);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarProveedor(@PathVariable Long id){
        proveedorRepo.deleteById(id);
    }
}
