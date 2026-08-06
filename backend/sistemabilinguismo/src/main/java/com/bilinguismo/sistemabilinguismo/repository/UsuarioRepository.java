package com.bilinguismo.sistemabilinguismo.repository;

import com.bilinguismo.sistemabilinguismo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByCorreoAndContrasena(String correo, String contrasena);

}
