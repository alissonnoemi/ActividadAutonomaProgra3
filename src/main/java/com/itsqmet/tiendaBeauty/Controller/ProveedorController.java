package com.itsqmet.tiendaBeauty.Controller;

import com.itsqmet.tiendaBeauty.Entity.Proveedor;
import com.itsqmet.tiendaBeauty.Service.ProveedorServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ProveedorController {
    @Autowired
    private ProveedorServicio proveedorServicio;

    @GetMapping("/proveedores")
    public String listarProveedores(Model model){
        List<Proveedor> proveedores = proveedorServicio.mostrarProveedores();
        model.addAttribute("proveedores", proveedores);
        return "pages/listaProveedores";
    }

    @GetMapping("/formularioProveedor")
    public String formularioProveedor(Model model){
        model.addAttribute("proveedor", new Proveedor());
        return "pages/formularioProveedor";
    }

    @PostMapping("/guardar-proveedor")
    public String guardarProveedor(@Valid @ModelAttribute Proveedor proveedor,
                                   BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "pages/formularioProveedor";
        } else {
            proveedorServicio.guardarProveedor(proveedor); // Guarda el proveedor
            return "redirect:/proveedores";
        }
    }

    @GetMapping("/editar-proveedor/{codigo}")
    public String actualizarProveedor(@PathVariable Long codigo, Model model){
        Optional<Proveedor> proveedor = proveedorServicio.buscarProveedorPorCodigo(codigo);
        model.addAttribute("proveedor", proveedor.orElse(new Proveedor()));
        return "pages/formularioProveedor";
    }

    @GetMapping("/eliminar-proveedor/{codigo}")
    public String eliminarProveedor(@PathVariable Long codigo){
        proveedorServicio.eliminarProveedor(codigo);
        return "redirect:/proveedores";
    }
}
