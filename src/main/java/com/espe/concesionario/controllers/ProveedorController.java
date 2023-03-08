package com.espe.concesionario.controllers;

import com.espe.concesionario.models.ProveedorModel;
import com.espe.concesionario.services.ProveedorService;
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
    ProveedorService proveedorService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProveedorModel> listarProveedors(){
        return proveedorService.listarProveedors();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ProveedorModel crearProveedor(@RequestBody ProveedorModel proveedorModel){
        return proveedorService.crearProveedor(proveedorModel);
    }


    @GetMapping(path = "/{id}")
    public Optional<ProveedorModel> proveedorPorId(@PathVariable(value = "id") Long proveedorId) {
        return proveedorService.proveedorPorId(proveedorId);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProveedorModel actualizarProveedor(@RequestBody ProveedorModel proveedorBody, @PathVariable Long id){
        return proveedorService.actualizarProveedor(proveedorBody, id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarProveedor(@PathVariable Long id){
        proveedorService.eliminarProveedor(id);
    }
}
