package com.itsqmet.tiendaBeauty.Service;

import com.itsqmet.tiendaBeauty.Entity.Proveedor;
import com.itsqmet.tiendaBeauty.Repository.provedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProveedorServicio {
    @Autowired
    private provedorRepositorio proveedorRepositorio;

    public List<Proveedor> mostrarProveedores() {
        return proveedorRepositorio.findAll();
    }

    public Optional<Proveedor> buscarProveedorPorCodigo(Long codigo) {
        return proveedorRepositorio.findById(codigo);
    }

    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepositorio.save(proveedor);
    }

    public void eliminarProveedor(Long codigo) {
        proveedorRepositorio.deleteById(codigo);
    }
}
