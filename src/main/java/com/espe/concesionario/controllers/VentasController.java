package com.espe.concesionario.controllers;

import com.espe.concesionario.models.VentasModel;
import com.espe.concesionario.repositories.VentasRepo;
import com.espe.concesionario.services.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/venta")

public class VentasController {
    @Autowired
    VentasService ventasService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VentasModel> listarVentas(){
        return ventasService.listarVentas();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public VentasModel creaVenta(@RequestBody VentasModel ventaModel){
        return ventasService.creaVenta(ventaModel);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Optional<VentasModel> ventaPorId(@PathVariable(value = "id") Long ventaId) {
        return ventasService.ventaPorId(ventaId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/{id}")
    public VentasModel actualizaVenta(@RequestBody VentasModel ventaModel, @PathVariable(value = "id") Long ventaId){
        return ventasService.actualizaVenta(ventaModel, ventaId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    public void eliminaVenta(@PathVariable(value = "id") Long ventaId){
        ventasService.borraVenta(ventaId);
    }

}
