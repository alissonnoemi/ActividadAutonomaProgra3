package com.itsqmet.tiendaBeauty.Service;

import com.itsqmet.tiendaBeauty.Entity.Producto;
import com.itsqmet.tiendaBeauty.Repository.productoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {
    @Autowired
    private productoRepositorio productoRepositorio;

    public List<Producto> mostrarProductos() {
        return productoRepositorio.findAll();
    }

    public List<Producto> buscarProductoPorNombre(String buscarProducto) {
        if (buscarProducto == null || buscarProducto.isEmpty()) {
            return productoRepositorio.findAll();
        } else {
            return productoRepositorio.findAll();
        }
    }
    //Buscar Libro por ID
    public Optional<Producto> buscarProductoId(Long id){
        return  productoRepositorio.findById(id);

    }

    public Producto guardarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    public void eliminarProducto(Long codigo) {
        productoRepositorio.deleteById(codigo);
    }

    public List<Producto> buscarPorNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return productoRepositorio.findAll();
        } else {
            return productoRepositorio.findByNombreContainingIgnoreCase(nombre);
        }
    }
}
