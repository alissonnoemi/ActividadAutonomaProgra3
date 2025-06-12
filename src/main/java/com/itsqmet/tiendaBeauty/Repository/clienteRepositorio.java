package com.itsqmet.tiendaBeauty.Repository;

import com.itsqmet.tiendaBeauty.Entity.Cliente;
import com.itsqmet.tiendaBeauty.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface clienteRepositorio  extends JpaRepository <Cliente, Long> {
    List<Cliente> findByNombreContainingIgnoreCase(String nombre);
}
