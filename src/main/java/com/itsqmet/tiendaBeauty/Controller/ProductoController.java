package com.itsqmet.tiendaBeauty.Controller;

import com.itsqmet.tiendaBeauty.Entity.Producto;
import com.itsqmet.tiendaBeauty.Entity.Proveedor;
import com.itsqmet.tiendaBeauty.Service.ProductoServicio;
import com.itsqmet.tiendaBeauty.Service.ProveedorServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductoController {
    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private ProveedorServicio proveedorServicio;

    @GetMapping("/productos")
    public String listarProductos(@RequestParam(name="buscarProducto", required = false, defaultValue = "")
                                 String buscarProducto, Model model){
        List<Producto> productos = productoServicio.buscarProductoPorNombre(buscarProducto);
        model.addAttribute("buscarProducto", buscarProducto);
        model.addAttribute("productos", productos);
        return "pages/listaProductos";
    }

    @GetMapping("/formularioProducto")
    public String formularioProducto(Model model){
        model.addAttribute("producto", new Producto());
        List<Proveedor> proveedores = proveedorServicio.mostrarProveedores();
        model.addAttribute("proveedores", proveedores);
        return "pages/formularioProducto";
    }

    @PostMapping("/guardar-producto")
    public String guardarProducto(@Valid @ModelAttribute Producto producto,
                                  BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("proveedores", proveedorServicio.mostrarProveedores());
            return "pages/formularioProducto";
        } else {
            productoServicio.guardarProducto(producto); // Guarda el producto
            return "redirect:/productos";
        }
    }

    @GetMapping("/editar-producto/{codigo}")
    public String actualizarProducto(@PathVariable Long codigo, Model model){
        Optional<Producto> producto = productoServicio.buscarProductoId(codigo);
        model.addAttribute("producto", producto.orElse(new Producto()));
        model.addAttribute("proveedores", proveedorServicio.mostrarProveedores());
        return "pages/formularioProducto";
    }

    @GetMapping("/eliminar-producto/{codigo}")
    public String eliminarProducto(@PathVariable Long codigo){
        productoServicio.eliminarProducto(codigo);
        return "redirect:/productos";
    }
}
