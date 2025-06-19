package com.itsqmet.tiendaBeauty.Service;

import com.itsqmet.tiendaBeauty.Entity.Rol;
import com.itsqmet.tiendaBeauty.Repository.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServicio {
    @Autowired
    private RolRepositorio rolRepositorio;
    //mostrar
    public List<Rol> mostrarListaRoles() {
        return rolRepositorio.findAll();
    }
}
