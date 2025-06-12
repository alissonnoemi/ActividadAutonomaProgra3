package com.itsqmet.tiendaBeauty.Repository;

import com.itsqmet.tiendaBeauty.Entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface facturaRepositorio extends JpaRepository <Factura, Long> {
    List<Factura> findByNumero(Long numero);
}
