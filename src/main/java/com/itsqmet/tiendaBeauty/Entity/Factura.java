package com.itsqmet.tiendaBeauty.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    @ManyToOne

    @NotNull(message = "Debe seleccionar un cliente")
    @JoinColumn(name = "cedula_cliente")
    private Usuario usuario;
    @NotNull(message = "Debe seleccionar un producto")
    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto producto;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer cantidad;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    private BigDecimal precio;
    private BigDecimal subtotal;
    private BigDecimal total;

}
