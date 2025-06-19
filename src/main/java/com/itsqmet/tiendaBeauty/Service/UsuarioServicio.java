package com.itsqmet.tiendaBeauty.Service;

import com.itsqmet.tiendaBeauty.Entity.Usuario;
import com.itsqmet.tiendaBeauty.Repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
@Autowired
    private UsuarioRepositorio usuarioRepositorio;
//cifrar contraseña
    @Autowired
    private PasswordEncoder passwordEncoder;
    //mostrar
    public List <Usuario> mostrarListaUusarios(){
        return usuarioRepositorio.findAll();
    }
    //buscar por id
    public Optional<Usuario> buscarUsuarioId(Long id){
        return usuarioRepositorio.findById(id);
    }
    //guardar
    public Usuario guardarUsuario(Usuario usuario){
        //cifrar
        String passwordEncriptado = passwordEncoder.encode(usuario.getPassword());
        //encriptado
        usuario.setPassword(passwordEncriptado);
        return  usuarioRepositorio.save(usuario);
    }
    //eliminar
    public void eliminarUsuario(Long id){
        usuarioRepositorio.deleteById(id);
    }
    // Java
    public List<Usuario> findByRol(String rol) {
        return usuarioRepositorio.findAll()
                .stream()
                .filter(u -> u.getRol() != null && u.getRol().getNombre().equalsIgnoreCase(rol))
                .collect(java.util.stream.Collectors.toList());
    }
}

