package com.itsqmet.tiendaBeauty.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@NoArgsConstructor
@Entity
public class Producto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;

    @NotNull(message = "El precio unitario es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    @Digits(integer = 6, fraction = 2, message = "El precio debe tener hasta 6 dígitos y 2 decimales")
    @Column(name = "precio_unitario", precision = 8, scale = 2)
    private BigDecimal precioUnitario;

    @NotNull(message = "Debe seleccionar un proveedor")
    @ManyToOne
    @JoinColumn(name = "codigo_proveedor")
    private Proveedor proveedor;
    @OneToMany(mappedBy = "producto" , fetch = FetchType.LAZY)
    private List<Factura> factura;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public @NotNull(message = "El precio unitario es obligatorio") @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0") @Digits(integer = 6, fraction = 2, message = "El precio debe tener hasta 6 dígitos y 2 decimales") BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(@NotNull(message = "El precio unitario es obligatorio") @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0") @Digits(integer = 6, fraction = 2, message = "El precio debe tener hasta 6 dígitos y 2 decimales") BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public @NotNull(message = "Debe seleccionar un proveedor") Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(@NotNull(message = "Debe seleccionar un proveedor") Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Factura> getFactura() {
        return factura;
    }

    public void setFactura(List<Factura> factura) {
        this.factura = factura;
    }
}
