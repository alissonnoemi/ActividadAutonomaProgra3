package com.itsqmet.tiendaBeauty.Repository;

import com.itsqmet.tiendaBeauty.Entity.Producto;
import com.itsqmet.tiendaBeauty.Entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface provedorRepositorio extends JpaRepository <Proveedor, Long> {
    List<Proveedor> findByNombreContainingIgnoreCase(String nombre);
}
