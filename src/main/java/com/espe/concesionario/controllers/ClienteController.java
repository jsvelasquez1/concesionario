package com.espe.concesionario.controllers;

import com.espe.concesionario.models.ClienteModel;
import com.espe.concesionario.repositories.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")

public class ClienteController {
    @Autowired
    ClienteRepo clienteRepo;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteModel> listarClientes(){
        return clienteRepo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ClienteModel crearCliente(@RequestBody ClienteModel clienteModel){
        return clienteRepo.save(clienteModel);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Optional<ClienteModel> clientePorId(@PathVariable(value = "id") Long clienteId) {
        return clienteRepo.findById(clienteId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteModel actualizarCliente(@RequestBody ClienteModel clienteBody, @PathVariable Long id){
        Optional<ClienteModel> existingClient = clienteRepo.findById(id);
        ClienteModel clienteActualizado = existingClient.get();
        if(existingClient!=null){
            clienteActualizado.setNombre(clienteBody.getNombre());
            clienteActualizado.setApellido(clienteBody.getApellido());
            clienteActualizado.setTelefono(clienteBody.getTelefono());
            clienteActualizado.setCedula(clienteBody.getCedula());
            clienteActualizado.setDireccion(clienteBody.getDireccion());
        }
        return clienteRepo.save(clienteActualizado);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarCliente(@PathVariable Long id){
        clienteRepo.deleteById(id);
    }
}
