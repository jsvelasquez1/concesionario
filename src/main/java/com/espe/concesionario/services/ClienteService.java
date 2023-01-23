package com.espe.concesionario.services;

import com.espe.concesionario.models.ClienteModel;
import com.espe.concesionario.repositories.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ClienteRepo clienteRepo;

    public List<ClienteModel> obtenerClientes(){
        return clienteRepo.findAll();
    }


}
