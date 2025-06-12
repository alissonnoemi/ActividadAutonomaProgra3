package com.itsqmet.tiendaBeauty.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
@NoArgsConstructor
@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cedula;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 10, message = "El nombre no puede tener más de 10 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 20, message = "El apellido no puede tener más de 20 caracteres")
    private  String apellido;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 50, message = "La dirección no puede tener más de 50 caracteres")
    private String direccion;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    @Column(name = "fecha_nacimiento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    @OneToMany (mappedBy = "cliente" , fetch = FetchType.LAZY)
    private List<Factura> facturas;


}
