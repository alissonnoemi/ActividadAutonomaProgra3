package com.itsqmet.tiendaBeauty.Controller;

import com.itsqmet.tiendaBeauty.Entity.Cliente;
import com.itsqmet.tiendaBeauty.Entity.Factura;
import com.itsqmet.tiendaBeauty.Entity.Producto;
import com.itsqmet.tiendaBeauty.Service.ClienteServicio;
import com.itsqmet.tiendaBeauty.Service.ProductoServicio;
import com.itsqmet.tiendaBeauty.Service.facturaServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class FacturaController {
    @Autowired
    private facturaServicio facturaServicio;
    @Autowired
    private ClienteServicio clienteServicio;
    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/facturas")
    public String listarFacturas(@RequestParam(name = "buscarFactura", required = false) Long buscarFactura, Model model) {
        List<Factura> facturas;
        if (buscarFactura != null) {
            Optional<Factura> factura = facturaServicio.buscarFacturaPorNumero(buscarFactura);
            facturas = factura.map(List::of).orElse(List.of());
        } else {
            facturas = facturaServicio.mostrarFacturas();
        }
        model.addAttribute("facturas", facturas);
        return "pages/listaFacturas";
    }
    @GetMapping("/formularioFactura")
    public String formularioFactura(Model model){
        model.addAttribute("factura", new Factura());
        List<Cliente> clientes = clienteServicio.mostrarClientes();
        List<Producto> productos = productoServicio.mostrarProductos();
        model.addAttribute("clientes", clientes);
        model.addAttribute("productos", productos);
        return "pages/formularioFactura";
    }

    @PostMapping("/guardar-factura")
    public String guardarFactura(@Valid @ModelAttribute Factura factura,
                                 BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return  "pages/formularioFactura";
        } else{
            return "redirect:/facturas";
        }

    }

    @GetMapping("/editar-factura/{numero}")
    public String actualizarFactura(@PathVariable Long numero, Model model){
        Optional<Factura> factura = facturaServicio.buscarFacturaPorNumero(numero);
        model.addAttribute("factura", factura.orElse(new Factura()));
        model.addAttribute("clientes", clienteServicio.mostrarClientes());
        model.addAttribute("productos", productoServicio.mostrarProductos());
        return "pages/formularioFactura";
    }

    @GetMapping("/eliminar-factura/{numero}")
    public String eliminarFactura(@PathVariable Long numero){
        facturaServicio.eliminarFactura(numero);
        return "redirect:/facturas";
    }
}
