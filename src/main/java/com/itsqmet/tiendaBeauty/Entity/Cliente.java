package com.itsqmet.tiendaBeauty.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cedula;
    private String nombre;
    private  String apellido;
    private String direccion;
    private Date fechaNacimiento;
}
