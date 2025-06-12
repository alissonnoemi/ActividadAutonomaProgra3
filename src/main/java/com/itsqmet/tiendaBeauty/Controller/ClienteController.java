package com.itsqmet.tiendaBeauty.Controller;

import com.itsqmet.tiendaBeauty.Entity.Cliente;
import com.itsqmet.tiendaBeauty.Service.ClienteServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClienteController {
    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/clientes")
    public String listarClientes(@RequestParam(name="buscarCliente", required = false, defaultValue = "")
                                     String buscarCliente, Model model){
        List<Cliente> clientes = clienteServicio.buscarClientePorNombre(buscarCliente);
        model.addAttribute("buscarCliente", buscarCliente);
        model.addAttribute("clientes", clientes);
        return "pages/listaClientes";
    }

    @GetMapping("/formularioCliente")
    public String formularioCliente(Model model){
        model.addAttribute("cliente", new Cliente());
        return "pages/formularioCliente";
    }
    @PostMapping("/guardar-cliente")
    public String guardarCliente(@Valid @ModelAttribute Cliente cliente,
                                 BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "pages/formularioCliente";
        } else {
            clienteServicio.guardarCliente(cliente); // Guarda el cliente
            return "redirect:/clientes";
        }
    }

    @GetMapping("/editar-cliente/{cedula}")
    public String actualizarCliente(@PathVariable Long id, Model model){
        Optional<Cliente> cliente = clienteServicio.buscarClienteId(id);
        model.addAttribute("cliente", cliente.orElse(new Cliente()));
        return "pages/formularioCliente";
    }

    @GetMapping("/eliminar-cliente/{cedula}")
    public String eliminarCliente(@PathVariable Long cedula){
        clienteServicio.eliminarCliente(cedula);
        return "redirect:/clientes";
    }
}
