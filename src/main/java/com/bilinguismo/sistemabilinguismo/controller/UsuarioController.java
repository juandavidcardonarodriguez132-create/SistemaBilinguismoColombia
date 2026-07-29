package com.bilinguismo.sistemabilinguismo.controller;

import com.bilinguismo.sistemabilinguismo.entity.Usuario;
import com.bilinguismo.sistemabilinguismo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/api/saludo")
    public String saludo() {
        return "Hola Juan, el Backend funciona correctamente";
    }

    @PostMapping("/api/usuarios")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }
    // Permite iniciar sesión
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
}