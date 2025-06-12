package com.itsqmet.tiendaBeauty.Service;

import com.itsqmet.tiendaBeauty.Entity.Cliente;
import com.itsqmet.tiendaBeauty.Repository.clienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {
    @Autowired
    private clienteRepositorio clienteRepositorio;

    public List<Cliente> mostrarClientes() {
        return clienteRepositorio.findAll();
    }

    public List<Cliente> buscarClientePorNombre(String nombre) {
        return clienteRepositorio.findByNombreContainingIgnoreCase(nombre);
    }
    //Buscar Libro por ID
    public Optional<Cliente> buscarClienteId(Long id){
        return  clienteRepositorio.findById(id);

    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    public void eliminarCliente(Long cedula) {
        clienteRepositorio.deleteById(cedula);
    }
}
