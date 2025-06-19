package com.itsqmet.tiendaBeauty.Controller;

import com.itsqmet.tiendaBeauty.Entity.Rol;
import com.itsqmet.tiendaBeauty.Entity.Usuario;
import com.itsqmet.tiendaBeauty.Service.RolServicio;
import com.itsqmet.tiendaBeauty.Service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@Controller
public class UsuarioController {
@Autowired
    private UsuarioServicio usuarioServicio;
@Autowired
    private RolServicio rolServicio;
//listar
    @GetMapping ("/usuarios")
    public String listaUsuarios(Model model){
        model.addAttribute("usuarios", usuarioServicio.mostrarListaUusarios());
        return "pages/listaUsuarios";
    }
    //Insertar un Nuevo Usuario
    @GetMapping ("/formularioUsuario")
    public String formularioUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        List<Rol> roles = rolServicio.mostrarListaRoles();
        model.addAttribute( "roles", roles);
        return "pages/formularioUsuario";
    }
    //guardar
    @PostMapping("/guardarUsuario")
    public String guardarUsuario(Usuario usuario){
        usuarioServicio.guardarUsuario( usuario);
        return "redirect:/usuarios";
    }
    //editar
    @GetMapping ("/editarUsuario")
    public String editarUsuario(Long id, Model model){
        Optional <Usuario> usuario = usuarioServicio.buscarUsuarioId(id);
        model.addAttribute("usuario", usuario);
        List<Rol> roles = rolServicio.mostrarListaRoles();
        model.addAttribute( "roles", roles);
        return "pages/formularioUsuario";
    }
    //eliminar
    @GetMapping ("/eliminarUsuario")
    public void eliminarUsuario(Long id){
        usuarioServicio.eliminarUsuario(id);
    }
}
