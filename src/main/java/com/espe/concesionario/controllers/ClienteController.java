package com.espe.concesionario.controllers;

import com.espe.concesionario.models.ClienteModel;
import com.espe.concesionario.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")

public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteModel> listarClientes(){
        return clienteService.listarClientes();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ClienteModel crearCliente(@RequestBody ClienteModel clienteModel){
        return clienteService.crearCliente(clienteModel);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Optional<ClienteModel> clientePorId(@PathVariable(value = "id") Long clienteId) {
        return clienteService.clientePorId(clienteId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteModel actualizarCliente(@RequestBody ClienteModel clienteBody, @PathVariable Long id){
        return clienteService.actualizarCliente(clienteBody, id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarCliente(@PathVariable Long id){
        clienteService.eliminarCliente(id);
    }
}
