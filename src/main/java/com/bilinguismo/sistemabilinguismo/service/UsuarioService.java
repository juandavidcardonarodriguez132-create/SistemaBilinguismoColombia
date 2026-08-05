package com.bilinguismo.sistemabilinguismo.service;

import com.bilinguismo.sistemabilinguismo.entity.Usuario;
import com.bilinguismo.sistemabilinguismo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Guardar un usuario
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Iniciar sesión
    public Usuario iniciarSesion(String correo, String contrasena) {
        return usuarioRepository.findByCorreoAndContrasena(correo, contrasena);
    }

    // Listar todos los usuarios
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Buscar un usuario por ID
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Actualizar un usuario
    public Usuario actualizar(Long id, Usuario datosUsuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();

            usuario.setNombre(datosUsuario.getNombre());
            usuario.setApellido(datosUsuario.getApellido());
            usuario.setCorreo(datosUsuario.getCorreo());
            usuario.setContrasena(datosUsuario.getContrasena());

            return usuarioRepository.save(usuario);
        }

        return null;
    }
}