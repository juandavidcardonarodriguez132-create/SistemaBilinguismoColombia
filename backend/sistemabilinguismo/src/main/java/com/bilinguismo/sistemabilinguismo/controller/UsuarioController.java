package com.bilinguismo.sistemabilinguismo.controller;

import com.bilinguismo.sistemabilinguismo.entity.Usuario;
import com.bilinguismo.sistemabilinguismo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Verificar funcionamiento del backend
    @GetMapping("/api/saludo")
    public String saludo() {
        return "Hola Juan, el Backend funciona correctamente";
    }

    // Registrar usuario
    @PostMapping("/api/usuarios")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }

    // Iniciar sesión
    @PostMapping("/api/login")
    public String iniciarSesion(@RequestBody Usuario usuario) {

        Usuario usuarioEncontrado = usuarioService.iniciarSesion(
                usuario.getCorreo(),
                usuario.getContrasena());

        if (usuarioEncontrado != null) {
            return "Autenticación satisfactoria";
        } else {
            return "Error en la autenticación";
        }
    }

    // Listar todos los usuarios
    @GetMapping("/api/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    // Buscar usuario por ID
    @GetMapping("/api/usuarios/{id}")
    public Optional<Usuario> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    // Actualizar usuario
    @PutMapping("/api/usuarios/{id}")
    public Usuario actualizarUsuario(
            @PathVariable Long id,
            @RequestBody Usuario usuario) {

        return usuarioService.actualizar(id, usuario);
    }
}