package com.itsqmet.tiendaBeauty.Entity;

import jakarta.persistence.*;

@Entity
public class Producto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long codigo;
    private String nombre;
    private String precioUnitario;
    @OneToMany(mappedBy = "producto")
    private Factura factura;


}
