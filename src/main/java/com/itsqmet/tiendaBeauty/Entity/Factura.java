package com.itsqmet.tiendaBeauty.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Factura {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long numero;
    private int cantidad;
    private String precio;
    private  String subtotal;
    private String total;
}
