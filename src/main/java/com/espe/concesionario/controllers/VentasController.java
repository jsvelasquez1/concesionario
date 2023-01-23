package com.espe.concesionario.controllers;

import com.espe.concesionario.models.VentasModel;
import com.espe.concesionario.repositories.VentasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/venta")

public class VentasController {
    @Autowired
    VentasRepo ventaRepo;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VentasModel> listarVentas(){
        return ventaRepo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public VentasModel creaVenta(@RequestBody VentasModel ventaModel){
        return ventaRepo.save(ventaModel);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Optional<VentasModel> ventaPorId(@PathVariable(value = "id") Long ventaId) {
        return ventaRepo.findById(ventaId);
    }
}
