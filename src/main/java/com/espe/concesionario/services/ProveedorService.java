package com.espe.concesionario.services;

import com.espe.concesionario.models.ProveedorModel;
import com.espe.concesionario.repositories.ProveedorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {
    @Autowired
    ProveedorRepo proveedorRepo;

    public List<ProveedorModel> listarProveedors(){
        return proveedorRepo.findAll();
    }

    public ProveedorModel crearProveedor(ProveedorModel proveedorModel){
        return proveedorRepo.save(proveedorModel);
    }


    public Optional<ProveedorModel> proveedorPorId(Long proveedorId) {
        return proveedorRepo.findById(proveedorId);
    }

    public ProveedorModel actualizarProveedor(ProveedorModel proveedorBody, Long id){
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

    public void eliminarProveedor(Long id){
        proveedorRepo.deleteById(id);
    }
}
