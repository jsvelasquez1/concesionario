package com.espe.concesionario.repositories;

import com.espe.concesionario.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepo extends JpaRepository<ClienteModel, Long> {

  /*  List<ClienteModel> clientes = new ArrayList<ClienteModel>();

    public ClienteModel crearCliente(ClienteModel clienteModel){
        try{
            clienteModel.setId_cliente((long) clientes.size()+1);
            clientes.add(clienteModel);

        }catch (Exception e){
            System.out.println(e);
        }
        return clienteModel;
    }

    public ArrayList<ClienteModel> listarClientes(){

        try{
            for (ClienteModel clienteModel: clientes) {
                System.out.println(clienteModel);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return (ArrayList<ClienteModel>) clientes;
    }

    public ClienteModel obtenerClientePorId(long id){
        ClienteModel aux = null;
        try{
            for (ClienteModel clienteModel: clientes) {
                if(clienteModel.getId_cliente() == id){
                    aux=clienteModel;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return aux;
    }
    public ClienteModel actualizarCliente(long id, ClienteModel body){
        ClienteModel aux = obtenerClientePorId(id);
        try{
            if(aux!=null){
                if(body.getNombre()!=null){
                    aux.setNombre(body.getNombre());
                }
                if(body.getApellido()!=null){
                    aux.setApellido(body.getApellido());
                }
                if(body.getTelefono()!=null){
                    aux.setTelefono(body.getTelefono());
                }
                if(body.getDireccion()!=null){
                    aux.setDireccion(body.getDireccion());
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return aux;
    }
    public void eliminarCliente(long id){
        try{
            ClienteModel aux = obtenerClientePorId(id);
            clientes.remove(aux);
        }catch (Exception e){
            System.out.println(e);
        }
    }*/
}
