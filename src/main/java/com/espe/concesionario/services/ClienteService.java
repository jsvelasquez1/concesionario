package com.espe.concesionario.services;

import com.espe.concesionario.models.ClienteModel;
import com.espe.concesionario.repositories.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepo clienteRepo;

    public List<ClienteModel> listarClientes(){
        return clienteRepo.findAll();
    }

    public ClienteModel crearCliente(ClienteModel clienteModel){
        return clienteRepo.save(clienteModel);
    }

    public Optional<ClienteModel> clientePorId(Long clienteId) {
        return clienteRepo.findById(clienteId);
    }

    public ClienteModel actualizarCliente(ClienteModel clienteBody, Long id){
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


    public void eliminarCliente(@PathVariable Long id){
        clienteRepo.deleteById(id);
    }

}
