package com.itsqmet.tiendaBeauty.Entity;

import jakarta.persistence.*;

@Entity
public class Factura {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long numero;
    @ManyToOne
    @JoinColumn(name = "cedula_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn (name = "codigo_producto")
    private Producto producto;
    private int cantidad;
    private String precio;
    private  String subtotal;
    private String total;
}
