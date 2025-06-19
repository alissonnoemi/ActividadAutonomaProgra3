package com.itsqmet.tiendaBeauty.Repository;

import com.itsqmet.tiendaBeauty.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario, Long> {
Optional<Usuario> findByUsername(String username);

}
