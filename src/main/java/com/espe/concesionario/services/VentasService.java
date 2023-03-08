package com.espe.concesionario.services;


import com.espe.concesionario.models.VentasModel;
import com.espe.concesionario.repositories.VentasRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class VentasService {
    @Autowired
    VentasRepo ventaRepo;

    public List<VentasModel> listarVentas(){
        return ventaRepo.findAll();
    }

    public VentasModel creaVenta(VentasModel ventaModel){
        return ventaRepo.save(ventaModel);
    }

    public Optional<VentasModel> ventaPorId(Long ventaId) {
        return ventaRepo.findById(ventaId);
    }
    public VentasModel actualizaVenta(VentasModel ventaModel, Long id){
        Optional<VentasModel> venta = ventaPorId(id);
        VentasModel ventaActualizado = venta.get();
        if(venta!=null){
            ventaActualizado.setClienteId(ventaModel.getClienteId());
            ventaActualizado.setEmpleadoId(ventaModel.getEmpleadoId());
            ventaActualizado.setVehiculoId(ventaModel.getVehiculoId());
            ventaActualizado.setFecha_compra(ventaModel.getFecha_compra());
            ventaActualizado.setPrecio(ventaModel.getPrecio());
        }
        return ventaRepo.save(ventaActualizado);
    }

    public void borraVenta(Long ventaId){
        ventaRepo.deleteById(ventaId);
    }
}
