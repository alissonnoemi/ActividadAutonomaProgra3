package com.itsqmet.tiendaBeauty.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cedula;
    private String nombre;
    private  String apellido;
    private String direccion;
    private Date fechaNacimiento;
    @OneToMany (mappedBy = "cliente")
    private List<Factura> facturas;


}
