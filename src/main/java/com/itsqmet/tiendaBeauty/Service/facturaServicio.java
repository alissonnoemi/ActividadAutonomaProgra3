package com.itsqmet.tiendaBeauty.Service;

import com.itsqmet.tiendaBeauty.Entity.Factura;
import com.itsqmet.tiendaBeauty.Repository.facturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class facturaServicio {
    @Autowired
    private facturaRepositorio facturaRepositorio;

    public List<Factura> mostrarFacturas() {
        return facturaRepositorio.findAll();
    }

    public Optional<Factura> buscarFacturaPorNumero(Long buscarFactura) {
        if (buscarFactura == null || buscarFactura <= 0) {
            return Optional.empty();
        }
        return facturaRepositorio.findById(buscarFactura);
    }
    public Factura guardarFactura(Factura factura) {
        // Calcula el subtotal (cantidad * precio unitario)
        if (factura.getCantidad() != null && factura.getPrecio() != null) {
            factura.setSubtotal(factura.getPrecio().multiply(java.math.BigDecimal.valueOf(factura.getCantidad())));
            factura.setTotal(factura.getSubtotal());
        }
        return facturaRepositorio.save(factura);
    }

    public void eliminarFactura(Long numero) {
        facturaRepositorio.deleteById(numero);
    }

}
